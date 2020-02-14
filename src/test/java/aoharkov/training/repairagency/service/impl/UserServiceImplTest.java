package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.TestObjectsInitializer;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import aoharkov.training.repairagency.repository.UserRepository;
import aoharkov.training.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.exception.validation.InvalidEmailException;
import aoharkov.training.repairagency.service.exception.validation.InvalidPasswordException;
import aoharkov.training.repairagency.service.mapper.UserMapper;
import aoharkov.training.repairagency.service.validator.Validator;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String ENCODED_PASSWORD = "encoded_password";
    private static final String PASSWORD = "password";
    private static final String INCORRECT_PASSWORD = "incorrect password";
    private static final String INCORRECT_ENCODED_PASSWORD = "incorrect encoded_password";
    private static final String EMAIL = "admin@gmail.com";
    private static final String INVALID_EMAIL = "admin#gmail.com";
    private static final String CORRECT_EMAIL_NOT_IN_DB = "admin@mail.ru";

    private static final UserEntity USER_ENTITY = TestObjectsInitializer.initUserEntity(1);
    private static final User USER = TestObjectsInitializer.initUser(1);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private Validator<User> userValidator;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @After
    public void resetMocks() {
        Mockito.reset(passwordEncoder, userRepository, userMapper);
    }

    @Ignore
    @Test
    public void userShouldLoginSuccessfully() {
        doNothing().when(userValidator).validateEmail(eq(EMAIL));
        when(userRepository.findByEmail(eq(EMAIL))).thenReturn(USER_ENTITY);
        when(passwordEncoder.encode(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userMapper.mapEntityToDomain(eq(USER_ENTITY))).thenReturn(USER);

        final User user = userService.login(EMAIL, PASSWORD);
        assertEquals(USER, user);

        verify(userValidator).validateEmail(eq(EMAIL));
        verify(userRepository).findByEmail(eq(EMAIL));
        verify(passwordEncoder).encode(eq(PASSWORD));
        verify(userMapper).mapEntityToDomain(eq(USER_ENTITY));
    }

    @Test
    public void userShouldNotLoginAsEmailIsNotValid() {
        doThrow(InvalidEmailException.class).when(userValidator).validateEmail(INVALID_EMAIL);
        thrown.expect(InvalidEmailException.class);

        userService.login(INVALID_EMAIL, PASSWORD);

        verify(userValidator).validateEmail(eq(INVALID_EMAIL));
        verifyZeroInteractions(userRepository);
        verifyZeroInteractions(passwordEncoder);
        verifyZeroInteractions(userMapper);
    }

    @Test
    public void userShouldNotLoginAsEmailNotFoundInDB() {
        doNothing().when(userValidator).validateEmail(eq(CORRECT_EMAIL_NOT_IN_DB));
        doThrow(EntityNotFoundException.class).when(userRepository).findByEmail(eq(CORRECT_EMAIL_NOT_IN_DB));

        thrown.expect(EntityNotFoundException.class);
        userService.login(CORRECT_EMAIL_NOT_IN_DB, PASSWORD);

        verify(userValidator).validateEmail(eq(CORRECT_EMAIL_NOT_IN_DB));
        verify(userRepository).findByEmail(eq(CORRECT_EMAIL_NOT_IN_DB));
        verifyZeroInteractions(passwordEncoder);
        verifyZeroInteractions(userMapper);
    }

    @Test
    public void userShouldNotLoginAsPasswordIsIncorrect() {
        doNothing().when(userValidator).validateEmail(eq(EMAIL));
        when(userRepository.findByEmail(eq(EMAIL))).thenReturn(USER_ENTITY);
        doThrow(InvalidPasswordException.class).when(passwordEncoder).encode(eq(INCORRECT_PASSWORD));

        thrown.expect(InvalidPasswordException.class);
        userService.login(EMAIL, INCORRECT_PASSWORD);

        verify(userValidator).validateEmail(eq(EMAIL));
        verify(userRepository).findByEmail(eq(EMAIL));
        verify(passwordEncoder).encode(INCORRECT_PASSWORD);
        verifyZeroInteractions(userMapper);
    }

    @Test
    public void userShouldRegisterSuccessfully() {
        doNothing().when(userValidator).validate(any(User.class));
        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(userMapper.mapDomainToEntity(eq(USER))).thenReturn(USER_ENTITY);
        when(userRepository.save(eq(USER_ENTITY))).thenReturn(USER_ENTITY);

        userService.register(USER);

        verify(userValidator).validate(any(User.class));
        verify(userRepository).findByEmail(anyString());
        verify(userMapper).mapDomainToEntity(USER);
        verify(userRepository).save(USER_ENTITY);
    }

    @Test
    public void userShouldNotRegisterAsEmailIsInvalid() {
        doThrow(InvalidEmailException.class).when(userValidator).validate(any(User.class));

        thrown.expect(InvalidEmailException.class);
        userService.register(USER);

        verify(userValidator).validate(any(User.class));
        verifyZeroInteractions(userRepository);
        verifyZeroInteractions(userMapper);
        verifyZeroInteractions(userRepository);
    }

    @Test
    public void userShouldNotRegisterAsEmailIsAlreadyInDB() {
        doNothing().when(userValidator).validate(any(User.class));
        doThrow(EntityAlreadyExistException.class).when(userRepository).findByEmail(EMAIL);

        thrown.expect(EntityAlreadyExistException.class);
        userService.register(USER);

        verify(userValidator).validate(any(User.class));
        verify(userRepository).findByEmail(anyString());
        verifyZeroInteractions(userMapper);
        verifyZeroInteractions(userRepository);
    }
}
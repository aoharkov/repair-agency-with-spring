package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.repository.UserRepository;
import aoharkov.training.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.exception.validation.InvalidEmailException;
import aoharkov.training.repairagency.service.exception.validation.InvalidPasswordException;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;
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

    private static final UserEntity USER_ENTITY = UserEntity.builder()
            .id(1)
            .password(ENCODED_PASSWORD)
            .email(EMAIL)
            .build();
    private static final User USER = User.builder()
            .id(1)
            .password(ENCODED_PASSWORD)
            .email(EMAIL)
            .build();

    @Mock
    private BCryptPasswordEncoder passwordEncoder;
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

    @Test
    public void userShouldLoginSuccessfully() {
        when(userRepository.findByEmail(eq(EMAIL))).thenReturn(USER_ENTITY);
        when(passwordEncoder.encode(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userMapper.mapEntityToDomain(eq(USER_ENTITY))).thenReturn(USER);

        final User user = userService.login(EMAIL, PASSWORD);
        assertEquals(USER, user);

        verify(userRepository).findByEmail(eq(EMAIL));
        verify(passwordEncoder).encode(eq(PASSWORD));
        verify(userMapper).mapEntityToDomain(eq(USER_ENTITY));
    }

    @Test(expected = InvalidEmailException.class)
    public void userShouldNotLoginAsEmailIsNotValid() {

        userService.login(INVALID_EMAIL, PASSWORD);

        verifyZeroInteractions(userRepository);
        verifyZeroInteractions(passwordEncoder);
        verifyZeroInteractions(userMapper);
    }

    @Test(expected = EntityNotFoundException.class)
    public void userShouldNotLoginAsEmailNotFoundInDB() {
        doThrow(EntityNotFoundException.class).when(userRepository).findByEmail(eq(CORRECT_EMAIL_NOT_IN_DB));

        userService.login(CORRECT_EMAIL_NOT_IN_DB, PASSWORD);

        verify(userRepository).findByEmail(eq(CORRECT_EMAIL_NOT_IN_DB));
        verifyZeroInteractions(passwordEncoder);
        verifyZeroInteractions(userMapper);
    }

    @Test(expected = InvalidPasswordException.class)
    public void userShouldNotLoginAsPasswordIsIncorrect() {
        when(userRepository.findByEmail(eq(EMAIL))).thenReturn(USER_ENTITY);
        doThrow(InvalidPasswordException.class).when(passwordEncoder).encode(eq(INCORRECT_PASSWORD));

        userService.login(EMAIL, INCORRECT_PASSWORD);

        verify(userRepository).findByEmail(eq(EMAIL));
        verify(passwordEncoder).encode(INCORRECT_PASSWORD);
        verifyZeroInteractions(userMapper);
    }

    @Test
    public void userShouldRegisterSuccessfully() {
        when(userRepository.findByEmail(anyString())).thenReturn(null);
        when(userMapper.mapDomainToEntity(eq(USER))).thenReturn(USER_ENTITY);
        doNothing().when(userRepository).save(USER_ENTITY);

        userService.register(USER);

        verify(userRepository).findByEmail(anyString());
        verify(userMapper).mapDomainToEntity(USER);
        verify(userRepository).save(USER_ENTITY);
    }

    @Test(expected = InvalidEmailException.class)
    public void userShouldNotRegisterAsEmailIsInvalid() {
        userService.register(USER);

        verifyZeroInteractions(userRepository);
        verifyZeroInteractions(userMapper);
        verifyZeroInteractions(userRepository);
    }

    @Test(expected = EntityAlreadyExistException.class)
    public void userShouldNotRegisterAsEmailIsAlreadyInDB() {
        doThrow(EntityAlreadyExistException.class).when(userRepository).findByEmail(EMAIL);

        userService.register(USER);

        verify(userRepository).findByEmail(anyString());
        verifyZeroInteractions(userMapper);
        verifyZeroInteractions(userRepository);
    }
}
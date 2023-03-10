package com.example.kafka

import com.ulisesbocchio.jasyptspringboot.encryptor.DefaultLazyEncryptor
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * JasyptConfigTest
 *
 * @author JungGyun.Choi
 * @version 1.0.0
 * @since 2023. 01. 10.
 */
//@Disabled
@ExtendWith(SpringExtension::class)
@SpringBootTest
class EncryptionTest {
    @Value("\${jasypt.encryptor.password}")
    lateinit var jasyptEncryptorPassword: String
    @Autowired
    lateinit var configurableEnvironment: ConfigurableEnvironment

    lateinit var encryptor: DefaultLazyEncryptor

    @BeforeEach
    internal fun setUp() {
        check(jasyptEncryptorPassword.isNotBlank()) {
            "jasypt.encryptor.password must not be null, empty or blank. "
        }
        encryptor = DefaultLazyEncryptor(configurableEnvironment)
    }

    @Test
    fun testForEncryption() {
        val source = "Test"
        println("source: $source")
        println("encrypted: ${encryptor.encrypt(source)}")
    }

    @Test
    fun testForDecryption() {
        // 암호화 되지 않은 문자열을 넣으면 복호화시 에러 발생함
        val source = "string want to decrypt"
        println("source: $source")
        println("decrypted: ${encryptor.decrypt(source)}")
    }
}
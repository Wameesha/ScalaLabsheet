object Q1 {
  def encryptCaesarCipher(plaintext: String, shift: Int): String = {
    val shifted = shift % 26
    plaintext.map { char =>
      if (char.isLetter) {
        val offset = if (char.isUpper) 'A' else 'a'
        ((char - offset + shifted) % 26 + offset).toChar
      } else {
        char
      }
    }
  }

  def decryptCaesarCipher(ciphertext: String, shift: Int): String = {
    val shifted = shift % 26
    ciphertext.map { char =>
      if (char.isLetter) {
        val offset = if (char.isUpper) 'A' else 'a'
        ((char - offset - shifted + 26) % 26 + offset).toChar
      } else {
        char
      }
    }
  }

  def cipher(data: String, shift: Int, cipherFunction: (String, Int) => String): String = {
    cipherFunction(data, shift)
  }

  def main(args: Array[String]): Unit = {
    val plaintext = "Hi! I'm Wameesha"
    val shift = 3

    // Encrypt the plaintext
    val encryptedText = cipher(plaintext, shift, encryptCaesarCipher)
    println(s"Encrypted Text: $encryptedText")

    // Decrypt the encrypted text
    val decryptedText = cipher(encryptedText, shift, decryptCaesarCipher)
    println(s"Decrypted Text: $decryptedText")
  }

  
}

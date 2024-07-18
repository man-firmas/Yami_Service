/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ao.controllers;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/**
 *
 * @author Man_firmas
 */
public class EncriptorAndDecriptor_Class {
 
    private static final String SALT = "familia7";
    private static Cipher cipher;

  static  public String AESencript (String input, String aesSECRET_KEY) throws InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException { 
    try {
       byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0};
    IvParameterSpec ivps = new IvParameterSpec(iv);
    SecretKeyFactory factor = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    KeySpec keyspec = new PBEKeySpec(aesSECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
    SecretKey sk = factor.generateSecret(keyspec);
    SecretKeySpec secretKeyspec = new SecretKeySpec(sk.getEncoded(),"AES");
    
    cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKeyspec, ivps);
    return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes(StandardCharsets.UTF_8)));
    
      } catch (NoSuchAlgorithmException e) {
          System.out.println(e);
      }
return null;
 }
    
  static  public String AESdecript (String input, String aesSECRET_KEY) throws InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException{
   try { 
  IvParameterSpec ivps = new IvParameterSpec(new byte []{0, 0, 0, 0, 0, 0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0 });
  SecretKeyFactory factor = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

  KeySpec keyspec = new PBEKeySpec(aesSECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
  SecretKey sk = factor.generateSecret(keyspec);
  SecretKeySpec secretKeyspec = new SecretKeySpec(sk.getEncoded(),"AES");
    
  Cipher  cipher_2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
  cipher_2.init(Cipher.DECRYPT_MODE, secretKeyspec, ivps);
  
 byte []original = cipher_2.doFinal(Base64.getDecoder().decode(input.getBytes()));
 String dec = new String (original);       
 return dec ;
    
     } catch(BadPaddingException e) {
          System.out.println(e);
          return null ;
      }   
  }
  static public String TDEencript (String cipherText, String secretKey) throws Exception{
   byte [] encryptKey = secretKey.getBytes();
      DESedeKeySpec spc = new DESedeKeySpec(encryptKey); 
      SecretKeyFactory keyfactor = SecretKeyFactory.getInstance("DESede");
      SecretKey theKey = keyfactor.generateSecret(spc);
      Cipher cipher_tde = Cipher.getInstance("DESede/CBC/PKCS5Padding");
      IvParameterSpec ivparameter = new IvParameterSpec(new byte []{12,34,56,78,90,87,65,43});
      cipher_tde.init(Cipher.ENCRYPT_MODE, theKey,ivparameter);
      byte []incrypted = cipher_tde.doFinal(cipherText.getBytes());
      return Base64.getEncoder().encodeToString(incrypted);
  } 
  
   static public String TDEdencript (String cipherText, String secretKey) throws Exception{
   byte [] encryptKey = secretKey.getBytes();
      DESedeKeySpec spc = new DESedeKeySpec(encryptKey); 
      SecretKeyFactory keyfactor = SecretKeyFactory.getInstance("DESede");
      SecretKey theKey = keyfactor.generateSecret(spc);
      Cipher cipher_tde = Cipher.getInstance("DESede/CBC/PKCS5Padding");
      IvParameterSpec ivparameter = new IvParameterSpec(new byte []{12,34,56,78,90,87,65,43});
      cipher_tde.init(Cipher.DECRYPT_MODE, theKey,ivparameter);
      byte []original = cipher_tde.doFinal(Base64.getDecoder().decode(cipherText.getBytes()));
      String dec = new String (original);       
   return dec ;  
   }

   
  }
  


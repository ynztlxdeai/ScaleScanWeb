package com.moyansz.common;


/**
 * 该类负责字节和整形、长整形、字符串、字符间进行转换。
 * 
 * @author lilong
 *
 */
public final class ByteUtils {

  /**
   * 定义十六进制所显示的字符数组
   */
  private static final char[] hexArray = {
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
      'f'
  };

  /**
   * A lookup table for the high order hex character.
   */
  private static final byte[] high = new byte[16];

  /**
   * A lookup table for the low order hex character.
   */
  private static final byte[] low = new byte[16];

  /**
   * Static initializer for the static hex character lookup tables.
   */
  static {
    createHigh();
    createLow();
  }

  /**
   * 转换字节数组为指定长度字符数组函数
   * @param byte[]
   * @return byte[]
   */
  public static byte[] wrapByteArray(byte[] bytes, int start, int len) {
    if (len < 1)
      return null;

    byte[] ret = new byte[len];

    if (start < 0 || bytes == null || start >= bytes.length)
      return ret;

    for (int i = 0; i < len; i++) {
      if (i >= bytes.length - start)
        break;
      ret[i] = bytes[start + i];
    }
    return ret;
  }

  /**
   * 截取有效字节数组函数
   * @param byte[]
   * @return byte[]
   */
  public static byte[] chopByteArray(byte[] bytes) {
    if (bytes == null)
      return null;

    int pos = 0;

    for (int i = 0; i < bytes.length; i++) {
      if ( (int) bytes[i] == 0)
        break;
      pos++;
    }
    return wrapByteArray(bytes, 0, pos);
  }


  /**
   * 字节数组转换为十六进制字符串函数
   * @param byte[]
   * @return String
   */
  public static String bytesToHexString(byte[] inByteArray) {
    if (inByteArray == null)
      return null;
    int position;
    StringBuffer returnBuffer = new StringBuffer();

    for (position = 0; position < inByteArray.length; position++) {
      returnBuffer.append(hexArray[ ( (inByteArray[position] >> 4) &
                                     0x0f)]);
      returnBuffer.append(hexArray[ (inByteArray[position] & 0x0f)]);
    }

    return returnBuffer.toString();
  }

  /**
   * 字节数组转换为长整形函数
   * @param byte[]
   * @return long
   */
  public static long bytesToLong(byte[] bytes) {
    long returnLong = 0;

    for (int n = 0; n < 8; n++) {
      returnLong = returnLong << 8;

      long aByte = bytes[n];

      if (aByte < 0) {
        aByte = aByte + 256;
      }

      returnLong = returnLong | aByte;
    }

    return returnLong;
  }


 

  /**
   * Creates a lookup table for encoding first character of a hex string
   * as a byte.
   *
   * @return  a byte array lookup table for the first hex character.
   */
  private static void createHigh() {
    byte b;

    for (int i = 0; i < high.length; i++) {
      b = (byte) i;
      high[i] = (byte) ( (b << 4) & 0xf0);
    }
  }

  /**
   * Creates a lookup table for encoding second character of a hex string
   * as a byte.
   *
   * @return  a byte array lookup table for the second hex character.
   */
  private static void createLow() {
    byte b;

    for (int i = 0; i < low.length; i++) {
      b = (byte) i;
      low[i] = (byte) (b & 0x0f);
    }
  }

  /**
   * Returns the index for the given hex character in the byte array lookup array.
   * This is used for both the hig order and low order hex characters.
   *
   * @param   c the character to get the lookup index.
   * @return  an index into a byte array lookup table for the given hex character.
   */
  private static int getIndex(char c) {
    if ( ('0' <= c) && (c <= '9')) {
      return ( (byte) c - (byte) '0');
    }
    else if ( ('a' <= c) && (c <= 'f')) {
      return ( (byte) c - (byte) 'a' + 10);
    }
    else if ( ('A' <= c) && (c <= 'F')) {
      return ( (byte) c - (byte) 'A' + 10);
    }
    else {
      return -1;
    }
  }

  /**
   * 十六进制字符串转换为字节数组函数
   * @param String
   * @return byte[]
   */
  public static byte[] hexStringToBytes(String str) {
    if (str == null)
      return null;

    byte b;
    byte b2;
    int len = str.length();
    byte[] retval = new byte[len / 2];

    int j = 0;

    for (int i = 0; i < len; i += 2) {
      b = high[getIndex(str.charAt(i))];
      b2 = low[getIndex(str.charAt(i + 1))];
      retval[j++] = (byte) (b | b2);
    }

    return retval;
  }

  /**
   * 整形转换为字节数组函数
   * @param int
   * @return byte[]
   */
  public static byte[] intToBytes(int i) {
    int ii = i;

    byte[] returnBytes = new byte[8];

    for (int n = 3; n >= 0; n--) {
      returnBytes[n] = (byte) ii;
      ii = ii >>> 8;
    }

    return returnBytes;
  }

  /**
   * 长整形转换为字节数组函数
   * @param long
   * @return byte[]
   */
  public static byte[] longToBytes(long l) {
    long ll = l;

    byte[] returnBytes = new byte[8];

    for (int n = 7; n >= 0; n--) {
      returnBytes[n] = (byte) ll;
      ll = ll >>> 8;
    }

    return returnBytes;
  }

  /**
   * Converts a integer in scope -127<i<128 to scope 0<=i<256，相当|num|
   *
   * @param i the integer to convert
   * @return the converted integer
   */
  public static int unSign(int i) {
    if (i < 0) {
      return i + 256;
    }
    else {
      return i;
    }
  }

 

}

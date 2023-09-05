package Семинар3;

import java.io.FileNotFoundException;

/**
 * CantFindExeption
 */
public class CantFindExeption extends FileNotFoundException {
  CantFindExeption(String msg) {
    super(msg);
  }
}
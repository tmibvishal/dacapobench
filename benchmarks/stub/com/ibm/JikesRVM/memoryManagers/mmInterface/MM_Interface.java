package com.ibm.JikesRVM.memoryManagers.mmInterface;

/**
 * As well as being a compilation stub, this provides forward compatibility 
 * to recent releases of JikesRVM.  
 * 
 * NOTE: the 'active' flag isn't thread safe, but it should provide
 * adequate protection against unbounded recursion.
 * 
 * @author Robin Garner
 * @date $Date: 2006-11-16 15:33:46 +1100 (Thu, 16 Nov 2006) $
 * @id $Id: MM_Interface.java 222 2006-11-16 04:33:46Z rgarner $
 *
 */
public class MM_Interface {
  private static boolean active = false;
  public static void harnessBegin() { 
    if (active)
      warn(); 
    else {
      active = true;
      com.ibm.jikesrvm.memorymanagers.mminterface.MM_Interface.harnessBegin();
      active = false;
    }
  }
  public static void harnessEnd() {
    if (active)
      warn(); 
    else {
      active = true;
      com.ibm.jikesrvm.memorymanagers.mminterface.MM_Interface.harnessEnd();
      active = false;
    }
  }
  private static void warn() {
    System.err.println("WARNING: stub com.ibm.JikesRVM.memoryManagers.mmInterface.MM_Interface called");
  }
}

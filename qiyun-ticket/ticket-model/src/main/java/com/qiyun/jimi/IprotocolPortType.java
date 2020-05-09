/**
 * IprotocolPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.qiyun.jimi;

public interface IprotocolPortType extends java.rmi.Remote {
    public String queryAwardTicket(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public String queryAwardNum(String arg0, String arg1, String arg2, String arg3) throws java.rmi.RemoteException;
    public String queryBdsfggMatchResult(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public String queryTicket(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public String queryBdMatchResult(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public String againstAndTimes(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public String queryJclqMatchResult(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public String queryJczqMatchResult(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
    public String queryBdMatch(String arg0, String arg1) throws java.rmi.RemoteException;
    public String queryBalance(String arg0, String arg1) throws java.rmi.RemoteException;
    public String queryJczqMatch(String arg0, String arg1) throws java.rmi.RemoteException;
    public String betTicket(String arg0, String arg1, String arg2, String arg3, String arg4) throws java.rmi.RemoteException;
    public String queryJclqMatch(String arg0, String arg1) throws java.rmi.RemoteException;
    public String queryServerTime(String arg0, String arg1) throws java.rmi.RemoteException;
    public String queryBdsfggMatch(String arg0, String arg1) throws java.rmi.RemoteException;
    public String queryIssueSell(String arg0, String arg1, String arg2) throws java.rmi.RemoteException;
}

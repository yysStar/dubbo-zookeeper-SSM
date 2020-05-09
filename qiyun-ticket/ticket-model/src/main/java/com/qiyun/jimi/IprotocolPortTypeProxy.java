package com.qiyun.jimi;

public class IprotocolPortTypeProxy implements IprotocolPortType {
  private String _endpoint = null;
  private IprotocolPortType iprotocolPortType = null;
  
  public IprotocolPortTypeProxy() {
    _initIprotocolPortTypeProxy();
  }
  
  public IprotocolPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initIprotocolPortTypeProxy();
  }
  
  private void _initIprotocolPortTypeProxy() {
    try {
      iprotocolPortType = (new IprotocolLocator()).getIprotocolPort();
      if (iprotocolPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iprotocolPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iprotocolPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iprotocolPortType != null)
      ((javax.xml.rpc.Stub)iprotocolPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public IprotocolPortType getIprotocolPortType() {
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType;
  }
  
  public String queryAwardTicket(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryAwardTicket(arg0, arg1, arg2);
  }
  
  public String queryAwardNum(String arg0, String arg1, String arg2, String arg3) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryAwardNum(arg0, arg1, arg2, arg3);
  }
  
  public String queryBdsfggMatchResult(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryBdsfggMatchResult(arg0, arg1, arg2);
  }
  
  public String queryTicket(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryTicket(arg0, arg1, arg2);
  }
  
  public String queryBdMatchResult(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryBdMatchResult(arg0, arg1, arg2);
  }
  
  public String againstAndTimes(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.againstAndTimes(arg0, arg1, arg2);
  }
  
  public String queryJclqMatchResult(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryJclqMatchResult(arg0, arg1, arg2);
  }
  
  public String queryJczqMatchResult(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryJczqMatchResult(arg0, arg1, arg2);
  }
  
  public String queryBdMatch(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryBdMatch(arg0, arg1);
  }
  
  public String queryBalance(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryBalance(arg0, arg1);
  }
  
  public String queryJczqMatch(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryJczqMatch(arg0, arg1);
  }
  
  public String betTicket(String arg0, String arg1, String arg2, String arg3, String arg4) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.betTicket(arg0, arg1, arg2, arg3, arg4);
  }
  
  public String queryJclqMatch(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryJclqMatch(arg0, arg1);
  }
  
  public String queryServerTime(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryServerTime(arg0, arg1);
  }
  
  public String queryBdsfggMatch(String arg0, String arg1) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryBdsfggMatch(arg0, arg1);
  }
  
  public String queryIssueSell(String arg0, String arg1, String arg2) throws java.rmi.RemoteException{
    if (iprotocolPortType == null)
      _initIprotocolPortTypeProxy();
    return iprotocolPortType.queryIssueSell(arg0, arg1, arg2);
  }
  
  
}
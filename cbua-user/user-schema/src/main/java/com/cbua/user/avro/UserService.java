/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.cbua.user.avro;

@org.apache.avro.specific.AvroGenerated
public interface UserService {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"UserService\",\"namespace\":\"com.cbua.user.avro\",\"types\":[{\"type\":\"record\",\"name\":\"CreateUser\",\"fields\":[{\"name\":\"firstName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"email\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"password\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]},{\"type\":\"record\",\"name\":\"UserDetails\",\"fields\":[{\"name\":\"firstName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"email\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}],\"messages\":{\"createUser\":{\"request\":[{\"name\":\"createUser\",\"type\":\"CreateUser\"}],\"response\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},\"getUser\":{\"request\":[{\"name\":\"userId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalId\":\"UUID\"}],\"response\":\"UserDetails\"},\"addAddressToUser\":{\"request\":[{\"name\":\"userId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"addressId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}],\"response\":\"null\"},\"getUsers\":{\"request\":[{\"name\":\"userIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}],\"response\":{\"type\":\"array\",\"items\":\"UserDetails\",\"default\":[]}}}}");
  /**
   */
  java.lang.String createUser(com.cbua.user.avro.CreateUser createUser);
  /**
   */
  com.cbua.user.avro.UserDetails getUser(java.lang.String userId);
  /**
   */
  void addAddressToUser(java.lang.String userId, java.lang.String addressId);
  /**
   */
  java.util.List<com.cbua.user.avro.UserDetails> getUsers(java.util.List<java.lang.String> userIds);

  @org.apache.avro.specific.AvroGenerated
  public interface Callback extends UserService {
    public static final org.apache.avro.Protocol PROTOCOL = com.cbua.user.avro.UserService.PROTOCOL;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void createUser(com.cbua.user.avro.CreateUser createUser, org.apache.avro.ipc.Callback<java.lang.String> callback) throws java.io.IOException;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void getUser(java.lang.String userId, org.apache.avro.ipc.Callback<com.cbua.user.avro.UserDetails> callback) throws java.io.IOException;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void addAddressToUser(java.lang.String userId, java.lang.String addressId, org.apache.avro.ipc.Callback<java.lang.Void> callback) throws java.io.IOException;
    /**
     * @throws java.io.IOException The async call could not be completed.
     */
    void getUsers(java.util.List<java.lang.String> userIds, org.apache.avro.ipc.Callback<java.util.List<com.cbua.user.avro.UserDetails>> callback) throws java.io.IOException;
  }
}
/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.cbua.address.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class AddressDetails extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4372511576130934439L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AddressDetails\",\"namespace\":\"com.cbua.address.avro\",\"fields\":[{\"name\":\"firstName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"lastName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"email\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<AddressDetails> ENCODER =
      new BinaryMessageEncoder<AddressDetails>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<AddressDetails> DECODER =
      new BinaryMessageDecoder<AddressDetails>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<AddressDetails> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<AddressDetails> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<AddressDetails> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<AddressDetails>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this AddressDetails to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a AddressDetails from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a AddressDetails instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static AddressDetails fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String firstName;
  @Deprecated public java.lang.String lastName;
  @Deprecated public java.lang.String email;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AddressDetails() {}

  /**
   * All-args constructor.
   * @param firstName The new value for firstName
   * @param lastName The new value for lastName
   * @param email The new value for email
   */
  public AddressDetails(java.lang.String firstName, java.lang.String lastName, java.lang.String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return firstName;
    case 1: return lastName;
    case 2: return email;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: firstName = value$ != null ? value$.toString() : null; break;
    case 1: lastName = value$ != null ? value$.toString() : null; break;
    case 2: email = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'firstName' field.
   * @return The value of the 'firstName' field.
   */
  public java.lang.String getFirstName() {
    return firstName;
  }


  /**
   * Sets the value of the 'firstName' field.
   * @param value the value to set.
   */
  public void setFirstName(java.lang.String value) {
    this.firstName = value;
  }

  /**
   * Gets the value of the 'lastName' field.
   * @return The value of the 'lastName' field.
   */
  public java.lang.String getLastName() {
    return lastName;
  }


  /**
   * Sets the value of the 'lastName' field.
   * @param value the value to set.
   */
  public void setLastName(java.lang.String value) {
    this.lastName = value;
  }

  /**
   * Gets the value of the 'email' field.
   * @return The value of the 'email' field.
   */
  public java.lang.String getEmail() {
    return email;
  }


  /**
   * Sets the value of the 'email' field.
   * @param value the value to set.
   */
  public void setEmail(java.lang.String value) {
    this.email = value;
  }

  /**
   * Creates a new AddressDetails RecordBuilder.
   * @return A new AddressDetails RecordBuilder
   */
  public static com.cbua.address.avro.AddressDetails.Builder newBuilder() {
    return new com.cbua.address.avro.AddressDetails.Builder();
  }

  /**
   * Creates a new AddressDetails RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AddressDetails RecordBuilder
   */
  public static com.cbua.address.avro.AddressDetails.Builder newBuilder(com.cbua.address.avro.AddressDetails.Builder other) {
    if (other == null) {
      return new com.cbua.address.avro.AddressDetails.Builder();
    } else {
      return new com.cbua.address.avro.AddressDetails.Builder(other);
    }
  }

  /**
   * Creates a new AddressDetails RecordBuilder by copying an existing AddressDetails instance.
   * @param other The existing instance to copy.
   * @return A new AddressDetails RecordBuilder
   */
  public static com.cbua.address.avro.AddressDetails.Builder newBuilder(com.cbua.address.avro.AddressDetails other) {
    if (other == null) {
      return new com.cbua.address.avro.AddressDetails.Builder();
    } else {
      return new com.cbua.address.avro.AddressDetails.Builder(other);
    }
  }

  /**
   * RecordBuilder for AddressDetails instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AddressDetails>
    implements org.apache.avro.data.RecordBuilder<AddressDetails> {

    private java.lang.String firstName;
    private java.lang.String lastName;
    private java.lang.String email;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.cbua.address.avro.AddressDetails.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.firstName)) {
        this.firstName = data().deepCopy(fields()[0].schema(), other.firstName);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.lastName)) {
        this.lastName = data().deepCopy(fields()[1].schema(), other.lastName);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing AddressDetails instance
     * @param other The existing instance to copy.
     */
    private Builder(com.cbua.address.avro.AddressDetails other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.firstName)) {
        this.firstName = data().deepCopy(fields()[0].schema(), other.firstName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.lastName)) {
        this.lastName = data().deepCopy(fields()[1].schema(), other.lastName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.email)) {
        this.email = data().deepCopy(fields()[2].schema(), other.email);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'firstName' field.
      * @return The value.
      */
    public java.lang.String getFirstName() {
      return firstName;
    }


    /**
      * Sets the value of the 'firstName' field.
      * @param value The value of 'firstName'.
      * @return This builder.
      */
    public com.cbua.address.avro.AddressDetails.Builder setFirstName(java.lang.String value) {
      validate(fields()[0], value);
      this.firstName = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'firstName' field has been set.
      * @return True if the 'firstName' field has been set, false otherwise.
      */
    public boolean hasFirstName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'firstName' field.
      * @return This builder.
      */
    public com.cbua.address.avro.AddressDetails.Builder clearFirstName() {
      firstName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'lastName' field.
      * @return The value.
      */
    public java.lang.String getLastName() {
      return lastName;
    }


    /**
      * Sets the value of the 'lastName' field.
      * @param value The value of 'lastName'.
      * @return This builder.
      */
    public com.cbua.address.avro.AddressDetails.Builder setLastName(java.lang.String value) {
      validate(fields()[1], value);
      this.lastName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'lastName' field has been set.
      * @return True if the 'lastName' field has been set, false otherwise.
      */
    public boolean hasLastName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'lastName' field.
      * @return This builder.
      */
    public com.cbua.address.avro.AddressDetails.Builder clearLastName() {
      lastName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'email' field.
      * @return The value.
      */
    public java.lang.String getEmail() {
      return email;
    }


    /**
      * Sets the value of the 'email' field.
      * @param value The value of 'email'.
      * @return This builder.
      */
    public com.cbua.address.avro.AddressDetails.Builder setEmail(java.lang.String value) {
      validate(fields()[2], value);
      this.email = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'email' field has been set.
      * @return True if the 'email' field has been set, false otherwise.
      */
    public boolean hasEmail() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'email' field.
      * @return This builder.
      */
    public com.cbua.address.avro.AddressDetails.Builder clearEmail() {
      email = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public AddressDetails build() {
      try {
        AddressDetails record = new AddressDetails();
        record.firstName = fieldSetFlags()[0] ? this.firstName : (java.lang.String) defaultValue(fields()[0]);
        record.lastName = fieldSetFlags()[1] ? this.lastName : (java.lang.String) defaultValue(fields()[1]);
        record.email = fieldSetFlags()[2] ? this.email : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<AddressDetails>
    WRITER$ = (org.apache.avro.io.DatumWriter<AddressDetails>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<AddressDetails>
    READER$ = (org.apache.avro.io.DatumReader<AddressDetails>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.firstName);

    out.writeString(this.lastName);

    out.writeString(this.email);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.firstName = in.readString();

      this.lastName = in.readString();

      this.email = in.readString();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.firstName = in.readString();
          break;

        case 1:
          this.lastName = in.readString();
          break;

        case 2:
          this.email = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}











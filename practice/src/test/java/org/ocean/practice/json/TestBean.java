package org.ocean.practice.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Objects;

public class TestBean implements Serializable {

  @JsonProperty
  private String dev;

  @JsonProperty
  private String mode;

  @JsonProperty
  private String map;

  @JsonProperty
  private long size;

  @JsonProperty
  private String uuid;

  @JsonProperty
  private String chardev;

  @JsonProperty
  private long align;

  public String getDev() {
    return dev;
  }

  public void setDev(String dev) {
    this.dev = dev;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public String getMap() {
    return map;
  }

  public void setMap(String map) {
    this.map = map;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public String isUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getChardev() {
    return chardev;
  }

  public void setChardev(String chardev) {
    this.chardev = chardev;
  }

  public long getAlign() {
    return align;
  }

  public void setAlign(long align) {
    this.align = align;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof TestBean)) {
      return false;
    }
    TestBean other = (TestBean) obj;
    return Objects.equals(this.dev, other.dev) && Objects.equals(this.mode, other.mode)
        && Objects.equals(this.map, other.map) && Objects.equals(this.size, other.size)
        && Objects.equals(this.uuid, other.uuid) && Objects.equals(this.chardev, other.chardev)
        && Objects.equals(this.align, other.align);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dev, mode, map, size, uuid, chardev, align);
  }

  @Override
  public String toString() {
    return "dev=" + dev + ", " + "mode=" + mode + ", " + "map=" + map + ", " + "size=" + size + ", "
        + "uuid=" + uuid + ", " + "chardev=" + chardev + ", " + "align=" + align;
  }
}

package club.banyuan.mbm.util;

import java.util.HashMap;
import java.util.UUID;

public class MbmSession extends HashMap<String, Object> {

  // 生成一个随机字符串
  private String sessionId = UUID.randomUUID().toString();

  private boolean isValid = true;

  public boolean isValid() {
    return isValid;
  }

  public void invalidate() {
    isValid = false;
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }
}

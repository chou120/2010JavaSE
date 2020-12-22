package club.banyuan.mbm.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtil {

  private static final Map<String, MbmSession> sessionMap = new ConcurrentHashMap<>();

  public static void invalidateSession(MbmSession session) {
    sessionMap.remove(session.getSessionId());
  }

  public static MbmSession getSession(String sessionId) {
    return sessionMap.get(sessionId);
  }

  public static void setSession(MbmSession session) {
    sessionMap.put(session.getSessionId(), session);
  }
}

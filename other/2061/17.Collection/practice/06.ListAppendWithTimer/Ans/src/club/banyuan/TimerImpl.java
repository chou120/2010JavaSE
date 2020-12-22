package club.banyuan;

public class TimerImpl implements Timer {

  private boolean isStart;
  private long start;
  private long end;

  @Override
  public void start() throws IllegalStateException {
    if (isStart) {
      throw new IllegalStateException("已经开始");
    }

    start = System.currentTimeMillis();
    isStart = true;
  }

  @Override
  public void stop() throws IllegalStateException {
    if (!isStart) {
      throw new IllegalStateException("已经停止");
    }

    end = System.currentTimeMillis();
    isStart = false;
  }

  @Override
  public void reset() {
    isStart = false;
    start = 0;
    end = 0;
  }

  @Override
  public long getTimeMillisecond() {
    return end - start;
  }
}

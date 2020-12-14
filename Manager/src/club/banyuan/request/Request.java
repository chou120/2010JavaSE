package club.banyuan.request;

/**
 * @author sanye
 * @version 1.0
 * @date 2020/12/14 11:20 上午
 */
public class Request {

  private String url;
  private String data;  //前端传递过来的json数据
  private String  contentLength;//前端传递过来数据的长度

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getContentLength() {
    return contentLength;
  }

  public void setContentLength(String contentLength) {
    this.contentLength = contentLength;
  }

}

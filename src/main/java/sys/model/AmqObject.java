package sys.model;

import java.io.File;
import java.io.Serializable;

/**
 * author: zf
 * Date: 2016/12/13  16:16
 * Description: activeMQ 发送对象信息模型，必须可序列化
 */
public class AmqObject implements Serializable{

    private static final long serialVersionUID = -4360457513700482237L;

    private String name;

    private String msg;

    private File file;


    @Override
    public String toString() {
        return "AmqObject{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                ", file=" + file +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

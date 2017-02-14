package resource.redis;
/**
* author: zf
* Date: 2017/2/14  14:46
* Description:
*/
public interface Function<E, T> {

    public T callback(E e);

}

package Service;

public class ServiceException extends RuntimeException{
    public ServiceException(String serviceException) {
        super(serviceException);
    }
}
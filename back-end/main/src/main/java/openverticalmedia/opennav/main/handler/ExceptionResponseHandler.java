package openverticalmedia.opennav.main.handler;


import openverticalmedia.opennav.common.exception.NotFoundException;
import openverticalmedia.opennav.common.exception.NotLoginException;
import openverticalmedia.opennav.common.model.MessageModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionResponseHandler {

    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public MessageModel notLogin(NotLoginException exception) {
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(exception.getMessage());
        return messageModel;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageModel notFound(NotFoundException exception) {
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(exception.getMessage());
        return messageModel;
    }
}
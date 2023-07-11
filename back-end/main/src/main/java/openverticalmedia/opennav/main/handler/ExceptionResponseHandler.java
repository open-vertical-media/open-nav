package openverticalmedia.opennav.main.handler;


import openverticalmedia.opennav.common.exception.ExistsException;
import openverticalmedia.opennav.common.exception.LogicException;
import openverticalmedia.opennav.common.exception.NotFoundException;
import openverticalmedia.opennav.common.exception.NotLoginException;
import openverticalmedia.opennav.common.model.MessageModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class ExceptionResponseHandler {

    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public MessageModel notLoginException(NotLoginException exception) {
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(exception.getMessage());
        return messageModel;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageModel notFoundException(NotFoundException exception) {
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(exception.getMessage());
        return messageModel;
    }

    @ExceptionHandler(LogicException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MessageModel logicException(LogicException exception) {
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(exception.getMessage());
        return messageModel;
    }

    @ExceptionHandler(ExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public MessageModel existsException(ExistsException exception) {
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(exception.getMessage());
        return messageModel;
    }
}
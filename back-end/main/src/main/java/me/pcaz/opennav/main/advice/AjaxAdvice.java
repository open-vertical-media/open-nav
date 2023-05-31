package me.pcaz.opennav.main.advice;

import me.pcaz.opennav.common.annotation.AjaxController;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(annotations = AjaxController.class)
public class AjaxAdvice {
}

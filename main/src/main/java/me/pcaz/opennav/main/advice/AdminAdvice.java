package me.pcaz.opennav.main.advice;

import me.pcaz.opennav.common.annotation.AdminController;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(annotations = AdminController.class)
public class AdminAdvice {
}

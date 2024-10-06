package com.github.matywaky.inventory.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                model.addAttribute("errorCode", 404);
                model.addAttribute("errorMessage", "Page not found.");
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                model.addAttribute("errorCode", 500);
                model.addAttribute("errorMessage", "Internal server error.");
            } else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                model.addAttribute("errorCode", 403);
                model.addAttribute("errorMessage", "Forbidden.");
            } else {
                model.addAttribute("errorCode", statusCode);
                model.addAttribute("errorMessage", "Unknown error.");
            }
        }

        return "error";
    }
}

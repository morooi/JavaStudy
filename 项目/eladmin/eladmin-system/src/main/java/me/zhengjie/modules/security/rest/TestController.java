package me.zhengjie.modules.security.rest;

import me.zhengjie.annotation.rest.AnonymousGetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @AnonymousGetMapping("/info")
    public ResponseEntity<Object> info() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().body(authentication);
    }

    @GetMapping("/infopro")
    @PreAuthorize("hasAuthority('menu:list')")
    public ResponseEntity<Object> infoPro() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok().body(authentication);
    }

}

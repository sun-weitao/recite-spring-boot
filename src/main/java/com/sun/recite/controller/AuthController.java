package com.sun.recite.controller;

import com.sun.recite.entity.Sentence;
import com.sun.recite.entity.Word;
import com.sun.recite.exception.LoginException;
import com.sun.recite.models.AuthenticationRequest;
import com.sun.recite.models.AuthenticationResponse;
import com.sun.recite.models.JsonResult;
import com.sun.recite.security.AdminUserDetailsService;
import com.sun.recite.service.SentenceService;
import com.sun.recite.service.WordService;
import com.sun.recite.utils.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AdminUserDetailsService userDetailsService;
    
    @Resource
    private SentenceService sentenceService;
    
	@Resource
	private WordService wordService;
    
    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> auth(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new LoginException("Incorrect password");
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    
    
    @GetMapping("/info")
    public ResponseEntity<?> info(){
    	Map<String, Object> userMap = new HashMap<String, Object>();
    	userMap.put("name","sun");
    	userMap.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    	return ResponseEntity.ok(JsonResult.success(userMap));
    }
    
    @GetMapping("/all")
    public ResponseEntity<JsonResult> all(){
    	List<Sentence> sentences = sentenceService.findAll();
    	List<Word> words = wordService.findAll();
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("sentences", sentences);
    	map.put("words", words);
    	return ResponseEntity.ok(JsonResult.success(map));
    }
}

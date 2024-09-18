package com.eunhyeong.myselectshop.controller;


import com.eunhyeong.myselectshop.dto.request.FolderRequestDto;
import com.eunhyeong.myselectshop.dto.response.FolderResponseDto;
import com.eunhyeong.myselectshop.security.UserDetailsImpl;
import com.eunhyeong.myselectshop.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;

    @PostMapping("/folders")
    public void addFolders(@RequestBody FolderRequestDto folderRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<String> folderNames = folderRequestDto.getFolderNames();
        folderService.addFolders(folderNames, userDetails.getUser());
    }

    @GetMapping("/folders")
    public List<FolderResponseDto> getFolders(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return folderService.getFolders(userDetails.getUser());
    }


}

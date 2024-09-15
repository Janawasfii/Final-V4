package com.example.Thawaq.Controller;

import com.example.Thawaq.Api.ApiResponse;
import com.example.Thawaq.DTO.ClientDTO;
import com.example.Thawaq.DTO.ExpertDTO;
import com.example.Thawaq.DTO.StoreAdminDTO;
import com.example.Thawaq.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @GetMapping("/get-id/{userId}")
    public ResponseEntity getUserById(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(userService.getUserById(userId));
    }

    @PostMapping("/register-client")
    public ResponseEntity registerClient(@Valid @RequestBody ClientDTO clientDTO) {
        userService.clientRegister(clientDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Client registered successfully"));
    }

    @PostMapping("/register-expert")
    public ResponseEntity registerExpert(@Valid @RequestBody ExpertDTO expertDTO) {
        userService.expertRegister(expertDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Expert registered successfully"));
    }

    @PostMapping("/register-store")
    public ResponseEntity registerAdmin(@Valid @RequestBody StoreAdminDTO storeAdminDTO) {
        userService.storeAdminRegister(storeAdminDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Store Admin registered successfully"));
    }

    @PutMapping("/update-client")
    public ResponseEntity updateClient(@Valid @RequestBody ClientDTO clientDTO) {
        userService.clientUpdate(clientDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Client updated successfully"));
    }

    @PutMapping("/update-expert")
    public ResponseEntity updateExpert(@Valid @RequestBody ExpertDTO expertDTO) {
        userService.expertUpdate(expertDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Expert updated successfully"));
    }

    @PutMapping("/update-store")
    public ResponseEntity updateAdmin(@Valid @RequestBody StoreAdminDTO storeAdminDTO) {
        userService.storeAdminUpdate(storeAdminDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Store Admin updated successfully"));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity delete(@PathVariable Integer userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
    }

    ///v2
    @PutMapping("/block-expert/{expertId}/{userId}")
    public ResponseEntity BlockExpert(@PathVariable Integer  expertId,@PathVariable Integer userId){
        userService.BlockExpert(expertId,userId);
        return ResponseEntity.status(200).body(new ApiResponse("Expert blocked successfully"));
    }
    ///v2
    @PutMapping("/unblock-expert/{expertId}/{userId}")
    public ResponseEntity UnblockExpert(@PathVariable Integer expertId,@PathVariable Integer userId){
        userService.UnblockExpert(expertId,userId);
        return ResponseEntity.status(200).body(new ApiResponse("Expert unblocked successfully"));
    }
    ///v2
    @PutMapping("/block-Store-admin/{storeAdminId}/{userId}")
    public ResponseEntity BlockStoreAdmin(@PathVariable Integer storeAdminId,@PathVariable Integer userId){
        userService.BlockStoreAdmin(storeAdminId,userId);
        return ResponseEntity.status(200).body(new ApiResponse("StoreAdmin blocked successfully"));
    }
    ///v2
    @PutMapping("/unblock-Store-admin/{storeAdminId}/{userId}")
    public ResponseEntity UnblockStoreAdmin(@PathVariable Integer storeAdminId,@PathVariable Integer userId){
        userService.UnBlockStoreAdmin(storeAdminId,userId);
        return ResponseEntity.status(200).body(new ApiResponse("Expert unblocked successfully"));
    }
}
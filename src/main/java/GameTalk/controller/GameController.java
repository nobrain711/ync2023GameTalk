package GameTalk.controller;

import GameTalk.DTO.Page.PageRequestDTO;
import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.service.GameServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
@Log4j2
@RequiredArgsConstructor
public class GameController {
    private final GameServiceImpl gameService;

    @GetMapping("/list")
    public ResponseEntity list(PageRequestDTO pageRequestDTO) {
        return ResponseEntity.ok(gameService.getList(pageRequestDTO));
    }

    @GetMapping(value = "/details/{gameId}")
    public HttpEntity<GameDetailsDTO> ResponseEntity(@PathVariable("gameId") Long gameId) {
        return ResponseEntity.ok(gameService.get(gameId));
    }
}
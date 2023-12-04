package GameTalk.controller;

import GameTalk.DTO.Page.PageRequestDTO;
import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.DTO.test.TestDTO;
import GameTalk.service.GameServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/games")
@Log4j2
@RequiredArgsConstructor
public class GameController {
    private final GameServiceImpl gameService;

    /* 컨트롤러에서 Json을 DTO만들기 위해 테스트 코드
    @PostMapping("/register")
    public void register(@RequestBody TestDTO dto) {
        System.out.println(dto);
    }*/
    @PostMapping("register")
    public void register(@RequestBody GameDetailsDTO gameDetailsDTO){
        gameService.register(gameDetailsDTO);
    }


    @GetMapping("/list")
    public ResponseEntity list(PageRequestDTO pageRequestDTO) {
        return ResponseEntity.ok(gameService.getList(pageRequestDTO));
    }

    @GetMapping(value = "/details/{gameId}")
    public HttpEntity<GameDetailsDTO> ResponseEntity(@PathVariable("gameId") Long gameId) {
        return ResponseEntity.ok(gameService.get(gameId));
    }
}

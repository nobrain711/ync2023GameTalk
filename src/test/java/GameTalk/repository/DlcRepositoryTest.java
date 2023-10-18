package GameTalk.repository;

import GameTalk.entity.DlcEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class DlcRepositoryTest {
    @Autowired
    GameRepository gameRepository;

    @Autowired
    DlcRepository dlcRepository;

    @Test
    void testInsert(){
        DlcEntity dlc = DlcEntity
                .builder()
                .game(gameRepository.findByTitle("Assassin's Creed Valhalla"))
                .title("Assassin's Creed Valhalla - Wrath of the Druids")
                .releaseDate(LocalDate.parse("2022-12-07"))
                .instructions("In 879 CE, Eivor receives a letter from her maternal cousin B\u00e1rid mac \u00cdmair, now King of Dublin, requesting her assistance in Ireland. Eivor agrees to help B\u00e1rid secure an alliance with Flann Sinna, who is to be crowned High King of Ireland. After uncovering and foiling a plot to assassinate Flann ahead of his coronation, he requests Eivor's help to gather allies and strengthen his rule. Upon taking the castle of Cashelore, Eivor discovers that Flann's army has been poisoned and seeks an antidote with Flann's advisor, Ciara ingen Medba. Eivor learns that the Children of Danu, a cult of druids who seek to oust the Norse and Christian faiths from Ireland, are responsible, and begins hunting down their members. Eivor also discovers that Ciara is a former cult member, having left upon learning of their extremist ways.\n"+
                        "In 881 CE, Eivor uncovers the identity of the cult's leader: Eogan mac Cartaigh, the Abbot of Armagh, who feigned Christian faith. While informing Flann and B\u00e1rid, Eogan has his forces besiege Clogher. B\u00e1rid is killed in the attack, prompting Eivor to exact revenge and kill Eogan. In the aftermath, the Kings of Ireland decide to eradicate the druidic faith entirely, and Flann reluctantly agrees to launch an inquisition against the druids. Enraged upon learning of this, Ciara goes to the Lia F\u00e1il to use its power to prevent her culture from being eradicated. She tries to take control of Flann and his men, but Eivor defeats her and the Lia F\u00e1il is destroyed. Flann reflects on his decision and promises to be a good king for all the people of Ireland, cancelling the inquisition. Meanwhile, Eivor meets with Sichfrith, B\u00e1rid's son, who succeeded him as King of Dublin. The two reflect on B\u00e1rid's dreams, and bond as family.\n")
                .build();

        dlcRepository.save(dlc);
    }

    /*@Test
    void testShow(){
        Object dlc = dlcRepository.findByDlcId(1L);

        System.out.println(dlc.toString());
    }*/
}
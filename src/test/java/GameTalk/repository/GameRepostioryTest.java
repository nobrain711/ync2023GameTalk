package GameTalk.repository;

import GameTalk.entity.GameEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class GameRepostioryTest {

    @Autowired
    private GameRepostiory  repostiory;

    @Test
    void testInsert(){
        GameEntity game = GameEntity
                .builder()
                .title("Assassin's Creed Valhalla")
                .releaseDate(LocalDate.parse("2022-12-07"))
                .instructions( "In 2020, the unexplained strengthening of Earth's magnetic field negatively affects the planet. Layla Hassan, Shaun Hastings, and Rebecca Crane receive a signal with coordinates in New England, where they exhume a Viking raider's remains. Layla, struggling with the Staff of Hermes Trismegistus' influence, enters the Animus to view the raider's memories.\n"+
                        "In 855 CE in Norway, a young Eivor Varinsdottir witnesses warlord Kjotve the Cruel sacking her hometown and killing her parents before she is rescued by Sigurd, son of King Styrbjorn of the Raven Clan. Seventeen years later, Eivor has been adopted by Styrbjorn, and pursues vengeance against Kjotve. Her latest attempt fails, but she recovers her father's axe. Touching it, Eivor experiences a vision of Odin, leading her to consult the local seeress, Valka. Valka induces another vision of Sigurd losing an arm before being consumed by a giant wolf.\n"+
                        "Sigurd returns from an expedition with foreigners Basim and Hytham, members of the Hidden Ones, who came to Norway to assassinate Kjotve, a member of the opposing Order of the Ancients. Defying Styrbjorn's orders, Eivor and Sigurd enlist King Harald's help to eliminate Kjotve. Following their victory, Harald declares his intention to unite Norway under his rule. Styrbjorn pledges fealty to Harald, angering Sigurd, who expected to inherit the crown. He and Eivor take loyalists in the clan on an exodus to England, establishing the settlement of Ravensthorpe. Eivor then secures alliances with neighboring Saxon kingdoms and Viking clans led by Ivar, Halfdan, Ubba Ragnarsson, Guthrum, and Ceolwulf of Mercia, and helps Hytham assassinate local Order members, following tip-offs from a \"Poor Fellow-Soldier of Christ.\"\n"+
                        "Eivor's visions continue. Valka gives her an elixir that makes her dream of Asgard from Odin's perspective. Hoping to avert his own fated death during Ragnar\u00f6k, Odin imprisons Loki's son Fenrir, who is foretold to kill him, and retrieves a magical mead from Jotunheim that will allow him and the other Aesir to be reincarnated. Layla realizes these are actually visions of the Isu shortly before the Great Catastrophe, and that Loki, who was forbidden to reincarnate himself after betraying Odin, found another way to ensure his survival.\n"+
                        "Sigurd and Basim discover an Isu relic, and Sigurd, with Basim's encouragement, comes to believe himself a god. Fulke, an Order agent and servant of King Alfred of Wessex, captures Sigurd, believing him to be an Isu or descendant thereof, and tortures him, removing his right arm. Eivor rallies her allies to kill Fulke and rescue Sigurd, who has also begun experiencing strange visions. Eivor later accompanies Sigurd back to Norway to investigate his visions, finding an Isu temple with a tree-shaped computer system. The siblings connect themselves to it and are seemingly transported to Valhalla, where they enjoy endless battles, until Eivor realizes it is just a simulation. Having become disillusioned with the pursuit of glory, Eivor persuades Sigurd to return to the real world, and escapes the simulation after resisting Odin. \n"+
                        "Upon awakening, Eivor is confronted by Basim, who reveals himself, Eivor, and Sigurd to be reincarnations of Loki, Odin, and Tyr, respectively. Having been overtaken by Loki's personality, Basim attacks Eivor, but is defeated and trapped in the simulation. Sigurd then abdicates leadership of the clan to Eivor, who returns to England. Later, Eivor and her allies join Guthrum's assault on Wessex, defeating Alfred's forces at the Battle of Chippenham. Eivor tracks down Afred, who reveals himself as both the leader of the Order and the \"Poor Fellow-Soldier of Christ.\" Disgusted by the Order's heresy against Christianity, Alfred sought to replace it with a new God-fearing order. Eivor spares Alfred and returns to Ravensthorpe to a hero's welcome. \n"+
                        "In the present, the Assassins deduce the strengthening magnetic field is a result of Desmond Miles' activation of the Isu towers in 2012. To stabilize the field, Layla travels to the Norway temple and enters the simulation. She meets Basim, who reveals that he led the Assassins to Eivor, and tells her how to stabilize the magnetic field. She does so, but this releases Basim and traps Layla in the simulation. Layla encounters a being called \"the Reader,\" and decides to work with him to prevent future disasters, allowing her mortal body to die. Meanwhile, Basim escapes the temple with the Staff of Hermes\u2014containing the consciousness of Loki's lover, Aletheia\u2014and meets Shaun and Rebecca. After they leave to bring William Miles, Basim enters the Animus to track down Loki's missing children.\n")
                .build();

        repostiory.save(game);
    }

    @Test
    void testFindId(){
        System.out.println(repostiory.findByGameIdForTitle("Assassin's Creed Valhalla"));
    }

    @Test
    void testShwo(){
        System.out.println(repostiory.findByGameId(1L));
    }

    @Test
    void testFindBytitle(){
        System.out.println(repostiory.findByTitle("Assassin's Creed Valhalla"));
    }
}
package GameTalk.repository;

import GameTalk.entity.GamesEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class GamesRepositoryTest {
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private SeriesRepository seriesRepository;

    // Game Info Insert
    @Test
    void insertTest() {
        GamesEntity build = GamesEntity.builder()
                .title("Assassin's Creed\\u2122")
                .info("In 2012, bartender Desmond Miles (Nolan North) is kidnapped by agents of Abstergo Industries, the world's largest pharmaceutical conglomerate, and is taken to their headquarters in Rome, Italy. Under the supervision of Dr. Warren Vidic (Philip Proctor) and his assistant Lucy Stillman (Kristen Bell), Desmond is forced to enter a machine called the Animus, which can translate his ancestors' genetic memories into a simulated reality. Vidic instructs Desmond to relive the early years of Alta\u00efr Ibn-La'Ahad (Philip Shahbaz), a senior member of the Assassin Brotherhood during the Third Crusade. \n" +
                        "In 1191, Alta\u00efr and two fellow Assassins\u2014brothers Malik (Haaz Sleiman) and Kadar Al-Sayf\u2014 are sent to Solomon's Temple to retrieve an artifact known as the Apple of Eden from the Brotherhood's sworn enemies, the Knights Templar. Blinded by arrogance, Alta\u00efr botches the mission, resulting in Kadar's death; however, Malik is able to grab the Apple before escaping. Although Alta\u00efr later partially redeems himself by fighting off a Templar attack on the Assassin home base of Masyaf, his mentor and superior, Al Mualim (Peter Renaday), demotes and orders him to assassinate nine individuals in order to regain his previous position and honour:\n" +
                        "As Alta\u00efr eliminates each target, he discovers all nine are Templars who had conspired to retrieve the Apple, revealed to be a relic of a long-forgotten civilization said to possess god-like powers. He also comes to question the nature of Al Mualim's orders while slowly becoming more humble and wise and making amends with Malik. During his assassination attempt on Robert, Alta\u00efr is tricked with a decoy: a Templar named Maria Thorpe (Eleanor Noble). Maria reveals that Robert had anticipated the Assassins would come after him and went to negotiate an alliance between the Crusaders and Saracens against them.  \n" +
                        "Sparing Maria's life, Alta\u00efr confronts Robert in the camp of King Richard I (Marcel Jeannin) and exposes his crimes. Unsure of whom to believe, Richard suggests a duel to determine the truth, remarking that God will decide the victor. After Alta\u00efr mortally wounds him, Robert identifies Al Mualim as the final conspirator, revealing that the latter has betrayed both the Assassins and Templars to acquire the Apple. Alta\u00efr returns to Masyaf, where Al Mualim has used the Apple to enthrall the population, as part of his plan to end the Crusade and all conflict in the world by imposing order by force. With the help of Malik and several Assassins brought for backup, Alta\u00efr storms the citadel and confronts Al Mualim in the gardens, resisting the Apple's powers and killing his mentor. He then tries to destroy the artifact, but instead unlocks a map showing the locations of countless other Pieces of Eden around the world.\n" +
                        "In the present, the Assassins launch an unsuccessful attack on the Abstergo facility to rescue Desmond, resulting in most of them being killed. After completing Alta\u00efr's memories, Vidic reveals to Desmond that Abstergo is a front for the modern-day Templars, seeking to find the remaining Pieces of Eden. With Desmond no longer useful, Vidic's superiors order him killed, but Lucy, who is implied to be an Assassin mole, convinces them to keep him alive for further testing. Desmond is left alone in his room, where he discovers strange drawings describing an upcoming catastrophic event.\n")
                .relesaeDate(LocalDate.parse("2008-04-09"))
                .build();

        gamesRepository.save(build);
    }

    // Game Info find
    @Transactional
    @Test
    void findByTitleTest(){
        System.out.println(gamesRepository.findByTitleContaining("Assassin's Creed"));
    }
}
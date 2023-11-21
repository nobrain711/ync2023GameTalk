package GameTalk.repository;

import GameTalk.DTO.game.GameListDTO;
import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.entity.*;
import GameTalk.entity.joinEntity.GameDeveloperEntity;
import GameTalk.entity.joinEntity.GameGenreEntity;
import GameTalk.entity.joinEntity.GamePlatformEntity;
import GameTalk.entity.joinEntity.GamePublisherEntity;
import GameTalk.repository.QueryDSL.CustomGameRepositoryImpl;
import GameTalk.repository.joinEntity.GameDeveloperRepository;
import GameTalk.repository.joinEntity.GameGenreRepostiory;
import GameTalk.repository.joinEntity.GamePlatformRepository;
import GameTalk.repository.joinEntity.GamePublisherReposiory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class GamesRepositoryTest {
    // root Entity
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private GenresRepository genresRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private PlatformRepository platformRepository;

    //join Entity
    @Autowired
    private GameGenreRepostiory gameGenreRepostiory;
    @Autowired
    private GameDeveloperRepository gameDeveloperRepository;
    @Autowired
    private GamePublisherReposiory gamePublisherReposiory;
    @Autowired
    private GamePlatformRepository gamePlatformRepository;

    // Query DSL repository
    @Autowired
    private CustomGameRepositoryImpl customGameRepository;

    // Series Insert info
    SeriesEntity seriesCheck(String name) {
        if (seriesRepository.findByName(name) == null) {
            SeriesEntity build = SeriesEntity
                    .builder()
                    .name(name)
                    .build();

            seriesRepository.save(build);
        }
        return seriesRepository.findByName(name);
    }

    // Game Info Insert
    @Test
    void gameInsertTest() {
        String name = "MONSTER HUNTER RISE";
        String series = "Monster Hunter";
        List<String> genres = Arrays.asList("Action");
        List<List<String>> developers = Arrays.asList(Arrays.asList("CAPCOM Co., Ltd.", "https://www.capcom.com/"));
        List<List<String>> publishers = Arrays.asList(Arrays.asList("CAPCOM Co., Ltd.", "https://www.capcom.com/"));
        List<String> platforms = Arrays.asList("Nintendo Switch", "Windows", "PlayStation 4", "PlayStation 5",
                "Xbox One", "Xbox Series X", "Xbox Series X");

        GamesEntity games = GamesEntity
                .builder()
                .title(name)
                .series(seriesCheck(series))
                .relesaeDate(LocalDate.parse("2022-01-13"))
                .info("Rise arc\n" +
                        "\n" +
                        "In Kamura Village, the player-character is informed they have been promoted to a Hunter by the Guild by the Wyverian twins Hinoa and Minoto. They escort the new Hunter to the village leader Fugen, though along the way, the Hunter catches sight of an unknown flying monster far in the distance. Fugen congratulates the Hunter on their success, but warns that they have been alerted about pending signs of \"The Rampage\", a mysterious calamity that occurred fifty years ago where a large horde of monsters attacked the village in a frenzied rage. Fugen tasks the Hunter to prepare themselves for a possible recurrence of the Rampage by helping with various quests to protect and supply the village with goods while building up their hunting. Further signs of the Rampage emerge, and Fugen instructs the Hunter to go to the Stronghold, a battleground that guards the gates to Kamura. After repelling the attack, the Hunter, Yomogi, the village chef, and Iori, the \"Buddy Handler\", are suddenly attacked by a tiger-like, mace-tailed fanged wyvern, forcing them to retreat. Fugen tells the trio that the monster is known as \"Magnamalo\" who appears alongside the Rampage and feeds on monsters of the horde. Under Fugen's orders, the Hunter slays Magnamalo. Upon returning to the village, Fugen and Hinoa congratulate the Hunter on their victory. Fugen then gives the Hunter his Long Sword, which has been passed down in Kamura for generations.\n" +
                        "\n" +
                        "After repelling another Rampage attack, as Hinoa wonders how long the Rampage is going to last, suddenly the same flying serpentine dragon-like monster that the Hunter saw earlier appears. Hinoa's eyes suddenly turn blue as she says, \"Where is my queen? Where is my queen?\" before regaining her senses. The monster is later identified as an Elder Dragon known as the Wind Serpent, Ibushi. After Ibushi is repelled, the group begins to question who Ibushi's \"queen\" is. Master Utsushi, the village's lookout, discovers who Ibushi's \"queen\" is: the Thunder Serpent, Narwa, who is Ibushi's female counterpart and mate. Further research from the guild reveals the origins of Ibushi and Narwa. Every fifty years, Ibushi, as well as Narwa, will emerge to mate with each other; in order to do so, Ibushi will wander the land to seek out Narwa. Ibushi is also known to cause destructive storms by sending dragon energy into the ground. This turbulence is strong enough to uproot trees and wipe out the landscape. This causes nearby monsters to become terrified and flee directly into Kamura Village. Meanwhile, Narwa seems to wait in a location she prefers until Ibushi is able to locate her. However, the disturbance caused by her presence and electromagnetic abilities tend to drive other monsters berserk, leading to a rampage event that regularly hits Kamura Village during the Serpent's mating process. This information reveals that the actions of the Serpent Elder Dragons are the primary cause of the Rampage. Due to the fact that Narwa had wiped out most of the village's hunters, they call on the Hunter to slay Narwa. After a fierce battle with the Thunder Serpent, Narwa is seemingly killed when she falls to her death. Narwa's corpse is not found, however, causing Fugen to believe that Narwa is still alive. At night, the Hunter witnesses Hinoa and Minoto (possessed by Ibushi and Narwa) talking to one other, saying that their offspring will roam across the earth.\n" +
                        "\n" +
                        "After fending off various elder dragons, the Hunter is told that Narwa and Ibushi have returned and finally united. Fugen calls on the Hunter to confront the two serpents and end the Rampage for good. The Hunter battles Ibushi, whose life force is devoured by Narwa, transforming her into Narwa the Allmother, greatly enhancing her power. The Hunter faces Narwa again and is aided by the unexpected arrival of Magnamalo, who attacks the Thunder Serpent. After a destructive battle, the Hunter slays Narwa and returns to the village. Fugen names the Hunter the Savior of Kamura as the village celebrates with a great feast and Hinoa states that the village is finally at peace.\n" +
                        "Sunbreak arc\n" +
                        "\n" +
                        "After the end of the Rampage, the hunter is hailed as a hero and peace returns to Kamura. This peace turns out to be short-lived, as a hermit crab-like monster, a Daimyo Hermitaur arrives in the shrine ruins. The Hunter and Utsushi investigate and slay the Hermitaur but a new, strange werewolf-like monster suddenly appears out of nowhere and attacks the two. They are unable to defeat it until the arrival of a knight from Elgado named Fiorayne, who repels the monster, then explains that the monster is a Lunagaron from the kingdom of Elgado.\n" +
                        "\n" +
                        "Fiorayne shares that her purpose in Kamura is to recruit the Hunter to help the people of Elgado face a trio of monsters called the Three Lords. One of the Three Lords, a vampyric elder dragon known as Malzeno, is believed to be making the monsters more aggressive and driving them out of the kingdom. As the monsters from Elgado are now threatening Kamura as well, Fugen accepts Fiorayne's request and allows the Hunter to travel to Elgado in order to meet its commander and defeat Malzeno.\n" +
                        "\n" +
                        "Arriving in Elgado, the Hunter meets Admiral Galleus and his allies. The Hunter and Fiorayne soon face the first of the Three Lords, Garangolm, and defeat it. The Hunter and Elgado's lead scientist, Bahari, encounter a species of glowing red moth-like creatures called Qurio. Bahari believes the Qurio may somehow be responsible for the madness plaguing the monsters of Elgado. The Hunter and Fiorayne soon face Lunagaron again, who is the second of the Three Lords, and defeat it as well, but are ambushed by Malzeno, who seems to be commanding the Qurio. Malzeno poisons Fiorayne with a virus from the Qurio as it departs.\n" +
                        "\n" +
                        "With Fiorayne's life in danger, the Hunter seeks out a doctor named Tadori, who is able to create a cure for the virus. Now convinced Malzeno is the source of the Qurio, Galleus commands the Hunter and Fiorayne to defeat the dragon once and for all. The Hunter and Fiorayne confront Malzeno in Elgado's destroyed citadel and slay it, causing a swarm of Qurio to fly away from its corpse. The threat seemingly ended, the people of Elgado begin to relax, but Galleus is concerned something else is at work and begins construction of a fleet of ships armed with dragonators.\n" +
                        "\n" +
                        "Although the Qurio have lost their host, they have begun killing monsters around the kingdom. The Hunter and Fiorayne find the citadel littered with the corpses of monsters, their life energy drained by the Qurio. The Qurio swarm gathers as a large pit opens from beneath the ocean near Elgado. An enormous monster, Gaismagorm, emerges from the pit, causing an earthquake. Before the creature can cause anymore destruction, Galleus arrives with his fleet and forces it back into the pit. Galleus and Bahari reveal to the Hunter and Fiorayne that the creature was the \"Archdemon of the Abyss\", a legendary monster that is said to rise up from underground and destroy the world. They also reveal that, based on their research, Gaismagorm is the true source of the Qurio and it sent them out to gather energy in order to free itself from beneath the sea. As Malzeno wasn't affected by the Qurio, it rivaled Gaismagorm and stalled its release. With Malzeno now dead, nothing is able to stop the Archfiend from emerging.\n" +
                        "\n" +
                        "Galleus gathers his ships and orders the Hunter and Fiorayne to descend into the pit to slay the creature. Within the pit, a destructive battle follows, with Galleus providing artillery fire to aid the Hunter. With his help, the Hunter and Fiorayne bring down Gaismagorm, causing the Qurio to begin to die. Reuniting with Galleus, the Hunter and their allies return to Elgado, where the people of both the kingdom and Kamura are celebrating their victory. Galleus and Bahari inform the Hunter that though their source is gone, the remaining Qurio are still a threat. Fiorayne asks the Hunter to stay with her in Elgado and continue to fight with her to protect the kingdom.\n" +
                        "\n" +
                        "Some time later, Kagero learns of the arrival of the Elder Dragon Amatsu, who was responsible for the destruction of his hometown Tsukito City, and goes to seek revenge. Yomogi intervenes and both are saved when the Hunter and Utsushi arrive, slaying Amatsu. Kagero expresses gratitude to the Hunter for avenging his homeland.\n" +
                        "\n" +
                        "After defeating Amatsu, Galleus and Bahari find a Malzeno that has not yet been infected by the Qurio, Primordial Malzeno. They become suspicious that Malzeno is killing the Qurio as Fiorayne assists the Hunter to fight the dragon once again. During the search, however, the Hunter and Fiorayne learn that Malzeno is attempting to kill the Qurio in order to prevent them from infecting it, and they resolve to save Malzeno by killing the Qurio. Malzeno thanks the Hunter and Fiorayne before flying away in peace to protect the kingdom alongside them. ")
                .build();

        gamesRepository.save(games);

        GamesEntity gamesEntity = gamesRepository.findByTitle(name);

        // insert gamegenre
        for (String genre : genres) {
            GenresEntity genresEntity = genresRepository.findByNameIgnoreCase(genre);
            if (genresEntity == null) {
                // insert genre
                GenresEntity build = GenresEntity
                        .builder()
                        .name(genre)
                        .build();

                genresRepository.save(build);

                genresEntity = genresRepository.findByNameIgnoreCase(genre);
            }

            // insert join entity
            GameGenreEntity build = GameGenreEntity
                    .builder()
                    .games(gamesEntity)
                    .genres(genresEntity)
                    .build();

            gameGenreRepostiory.save(build);
        }

        // insert gamedevelop
        for (List<String> developer : developers) {
            DevelopersEntity developersEntity = developerRepository.findByNameIgnoreCase(developer.get(0));
            if (developersEntity == null) {
                // insert developer
                DevelopersEntity build = DevelopersEntity
                        .builder()
                        .name(developer.get(0))
                        .url(developer.get(1))
                        .build();

                developerRepository.save(build);

                developersEntity = developerRepository.findByNameIgnoreCase(developer.get(0));
            }

            GameDeveloperEntity build = GameDeveloperEntity
                    .builder()
                    .games(gamesEntity)
                    .developers(developersEntity)
                    .build();

            gameDeveloperRepository.save(build);
        }

        for (List<String> publisher : publishers) {
            PublishersEntity publishersEntity = publisherRepository.findByNameIgnoreCase(publisher.get(0));
            if (publishersEntity == null) {
                // insert publisher
                PublishersEntity build = PublishersEntity
                        .builder()
                        .name(publisher.get(0))
                        .url(publisher.get(1))
                        .build();

                publisherRepository.save(build);

                publishersEntity = publisherRepository.findByNameIgnoreCase(publisher.get(0));
            }


            GamePublisherEntity build = GamePublisherEntity
                    .builder()
                    .games(gamesEntity)
                    .publishers(publishersEntity)
                    .build();

            gamePublisherReposiory.save(build);
        }

        // insert game_platform
        for (String platform : platforms) {
            PlatformEntity platformEntity = platformRepository.findByNameIgnoreCase(platform);
            if (platformEntity == null) {
                // insert platform
                PlatformEntity build = PlatformEntity
                        .builder()
                        .name(platform)
                        .build();

                platformRepository.save(build);
                platformEntity = platformRepository.findByNameIgnoreCase(platform);
            }


            GamePlatformEntity build = GamePlatformEntity
                    .builder()
                    .games(gamesEntity)
                    .platforms(platformEntity)
                    .build();

            gamePlatformRepository.save(build);
        }
    }

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

    // findAll
    @Test
    @Transactional
    void findAllTest() {
        List<GamesEntity> gamesEntities = gamesRepository.findAll();

        for (GamesEntity gamesEntity : gamesEntities) {
            System.out.println(gamesEntity);
        }
    }

    // Game Info find
    @Test
    @Transactional
    void gameInfoPrintTest() {
        // game Entity
        //  GamesEntity gamesEntity = gamesRepository.findByTitle("Assassin's Creed\\u2122");
        GamesEntity gamesEntity = gamesRepository.findByTitle("MONSTER HUNTER RISE");
        // gener Entity
        List<GameGenreEntity> gameGenreEntities = gamesEntity.getGameGenre();
        // developer Entity
        List<GameDeveloperEntity> gameDeveloperEntities = gamesEntity.getGameDeveloper();
        // publisher Entity
        List<GamePublisherEntity> gamePublisherEntities = gamesEntity.getGamePublisher();
        // platform Entity
        List<GamePlatformEntity> gamePlatformEntities = gamesEntity.getGamePlatform();

        System.out.printf("Id: %d\nTitle: %s\nInfo %s\nReleaseDate: %s%n",
                gamesEntity.getGameId(),
                gamesEntity.getTitle(),
                gamesEntity.getInfo().substring(0, 100),
                gamesEntity.getRelesaeDate());
        System.out.print("Gener: ");
        for (GameGenreEntity gameGenre : gameGenreEntities)
            System.out.print(gameGenre.getGenres().getName() + " ");

        System.out.print("\nDeveloper\n");
        for (GameDeveloperEntity gameDeveloper : gameDeveloperEntities)
            System.out.print("Name: " + gameDeveloper.getDevelopers().getName() + " url: " + gameDeveloper.getDevelopers().getUrl());

        System.out.print("\nPublisher");
        for (GamePublisherEntity gamePublisher : gamePublisherEntities)
            System.out.println("Name: " + gamePublisher.getPublishers().getName() + " url: " + gamePublisher.getPublishers().getUrl());

        System.out.print("\nPlatform: ");
        for (GamePlatformEntity gamePlatform : gamePlatformEntities)
            System.out.print(gamePlatform.getPlatforms().getName() + " ");
    }

    // Game List Test
    @Test
    @Transactional
    void paging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("gameId").descending());
        Page<Object[]> list = customGameRepository.getList(pageable);

    }

    @Test
    @Transactional
    void Details() {
        GameDetailsDTO details = customGameRepository.detail(1L);
    }
}

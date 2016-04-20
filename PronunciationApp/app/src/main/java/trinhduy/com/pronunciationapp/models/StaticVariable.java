package trinhduy.com.pronunciationapp.models;

import trinhduy.com.pronunciationapp.R;
import trinhduy.com.pronunciationapp.activities.PracticeSyllableActivity;
import trinhduy.com.pronunciationapp.activities.TopicActivity;
import trinhduy.com.pronunciationapp.fragments.LessonFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SON on 1/29/2016.
 */
public class StaticVariable {
    public static StaticVariable inst;
    public static List<SoundData> listSound = new ArrayList<SoundData>();
    public static HashMap<String, ArrayList<WordData>> WordExampleHashMap = new HashMap<String, ArrayList<WordData>>();
    public static HashMap<String, String> SoundLessonRule = new HashMap<String, String>();
    public static HashMap<String, String> OtherLessonRule = new HashMap<String, String>();
    public static HashMap<Integer, ArrayList<SyllableQuestion>> SyllableQuestionLesson = new HashMap<Integer, ArrayList<SyllableQuestion>>();
    public static HashMap<Integer, ArrayList<SyllableQuestion>> WordStressQuestionLesson = new HashMap<Integer, ArrayList<SyllableQuestion>>();
    public static HashMap<Integer, ArrayList<SyllableQuestion>> SentenceStressQuestion = new HashMap<Integer, ArrayList<SyllableQuestion>>();
    public static HashMap<Integer, ArrayList<SyllableQuestion>> LinkingQuestion = new HashMap<Integer, ArrayList<SyllableQuestion>>();
    public static HashMap<String, ArrayList<SyllableLessonTitle>> StressLessonTitle = new HashMap<String, ArrayList<SyllableLessonTitle>>();
    public static ArrayList<SentenceExample> listSentenceStressExample = new ArrayList<SentenceExample>();
    public static ArrayList<SentenceExample> listLinkingExample = new ArrayList<SentenceExample>();
    public static ArrayList<WordData> listWordSyllableExample = new ArrayList<WordData>();
    public static ArrayList<WordData> listWordStressExample = new ArrayList<WordData>();

    public static final String NUM_OF_QUESTION = "numOfQuestion";
    public static final String POSITION = "position";
    public static HashMap<String, String> VideoOtherLessons = new HashMap<String, String>();

    public StaticVariable() {
        setStaticSoundData();
        setStaticWordExampleData();
        setStaticSoundLessonRule();
        setStaticSyllableLessonTitle();
        setStaticSyllableQuestionLesson1();
        setStaticSyllableExample();
        setStaticWordStressLessonTitle();
        setStaticWordStressQuestionLesson1();
        setStaticSentenceStressTitle();
        setStaticSentenceStressQuestion();
        setStaticLinkingLessonTitle();
        setStaticLinkingQuestion();
        setStaticSyllableLessonRule();
        setStaticDataSentenceStressExample();
        setStaticLinkingExample();
        setDefaultSyllableExample();
        setDefaultWordStressExample();
        setStaticLinkVideoOtherLesson();

    }

    private void setStaticLinkVideoOtherLesson() {
        VideoOtherLessons.put(TopicActivity.WORD_STRESS_LESSON, "65AgbiwQ6ko");
        VideoOtherLessons.put(TopicActivity.SYLLABLE_LESSON, "qu51ECdLkIU");
        VideoOtherLessons.put(TopicActivity.SENTENCE_STRESS, "UbcEiFTmkQo");
        VideoOtherLessons.put(TopicActivity.LINKING, "gAHUTKm_1n0");
    }

    private void setStaticSyllableExample() {
    }

    public static StaticVariable getInst() {
        if (inst == null) {
            inst = new StaticVariable();
        }
        return inst;
    }

    private void setStaticSoundLessonRule() {
        String lessonIORule = "-It's a dipthong-which means you move from one vowel position to another in one syllable.\n" +
                "\r\n-Start in a close-mid position around the /ɪ/ vowel and move to a mid central position /ə/";
        String lessonUORule = "-To produce /ʊə/,the front of the back of the tongue is raised and then it moves towards /ə/.\n " +
                "\r\n-/ʊə/ is often mispronounced as /u:ə/\n";
        String lessonAIRule = "-The tongue begins back and low in the oral cavity and moves to a mid-high front position.\n" +
                "\r\n-The mandible moves from an open to a more close position.\n" +
                "\r\n The lips are unrounded.\n" +
                "\r\n -The vocal folds are adducted and vibrating.\n";
        String lessonOIRule = "-The tongue moves from a low-mid position to a mid-high position.The lips move from a rounded to unrounded configuration.\n" +
                "\r\n-The mandible is in a relatively neutral position\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonOURule = "-The tongue body back but lower than /u/,with the primary contriction in the pharyngeal region.\n" +
                "\r\n-The mandible is slightly lowered.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonEORule = "-The first part of this dipthong is more open than the short vowel /e/,then glides to /ə//The lips remain neutrally open..\n" +
                "\r\n-Most native speakers use /æ/ as the starting point of this dipthong..\n";
        String lessonAURule = "The tongue moves from a low-mid position to a mid-high position.\n" +
                "\r\n-The tongue begins back and low in the oral cavity and moves to a mid-high front position" +
                "\r\n-The mandible elevates during sound production. \n" +
                "\r\n=The lips move from an unrounded to a rounded configuration.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonEIRule = "-Your lips isn't rounded,just relaxed.\n" +
                "\r\n-The tongue moves from the mid-high to high position";
        String lessonLongIRule = "-The tongue is positioned forward and high in the oral cavity with the sides in contact with the teeth laterally and the tips positioned behind the lower teeth.\n" +
                "\r\n-The mandible is elevated.\n" +
                "\r\n-The lips are unrounded,and may be retracted.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonLongURule = "The tongue body is elevated into a high and back position with contact against the upper molars,while the tongue root is advanced to open the pharyngeal airway.\n" +
                "\r\n-The mandible is elevated.\n" +
                "\r\n-The lips are rounded and protruded.\n" +
                "\r\n-The vocal folds are adducted and vibrating/\n";
        String lessonLongARule = "-The tongue body is poisitioned back and low in the oral cavity.\n" +
                "\r\n-The mandible is lowered more than the rest of the backs vowels.\n" +
                "\r\n-The lips are unrounded and wipe open.\n" +
                "\r\n-The vocal folds are adducted and vibrating.";
        String lessonLongORule = "-The tongue is poisitioned back and in a low-mid position with respect to height.\n" +
                "\r\n-The mandible is slightly lowered.\n" +
                "\r\n-The lips are rounded,but less than /u/ or/o/" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonLongERule = "-The tongue is slightly above the neutral position with some bunching in palatal region.\n" +
                "\r\n-The mandible is slightly lowered.\n" +
                "\r\n-The lips are usally rounded.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonShortIRule = "-The tongue is poisitioned forward and slightly lower in the oral cavity than for /i:/,with the sides in contact with the teeth laterally and the tip positioned behind the lower teeth.\n" +
                "\r\n-The mandible is slightly lower than for /i:/.\n" +
                "\r\n-The lips are unrounded.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonShortURule = "-The tongue body is back and elevated into a mid-high position with contact against the upper molars,while the tongue root is not as other back vowels.\n" +
                "\r\n-The mandible is elevated but may lower slightly.\n" +
                "\r\n-The lips are usally rounded and protruded.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonShortARule = "-The tongue is in the center of the oral cavity.\n" +
                "\r\n-The jaw is slightly lowered,although its position varies depending on phonetic context.\n" +
                "\r\n-The lips are unrounded.\n" +
                "\r\n-The vocal folds are adducted and vibrating.";
        String lessonShortORule = "The tongue body is positioned back and low in the oral cavity.\n" +
                "\r\n-The mandible is lowered more than the rest of the back vowels.\n" +
                "\r\n-The lips are unrounded and wide open.\n";
        String lessonShortOWRule = "-The tongue is slightly above the neutral positioned with some bunching in the palatal region.\n" +
                "\r\n-The mandible is slightly lowered.\n " +
                "\r\n-The lips are usually rounded.\n" +
                "\r\n-The vocal folds are adducted and vibrating.";
        String lessonShortERule = "-The tongue is positioned forward and high in the oral cavity with the sides in contact with the teeth laterally" +
                "and the tip positioned behind the lower teeth.\n" +
                "\r\n-The lips are unrounded and may be retracted.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonShortAERule = "The tongue is positioned slightly forward and low in the oral cavity,with the tip positioned behind the lower teeth.\n" +
                "\r\n-The mandible is lowered more than for any other front vowel.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n";
        String lessonConsonantB = "-The lips are brought together to obstruct the oral cavity.\n" +
                "\r\n-Tongue position may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n" +
                "\r\n-Air pressure build up behind obstructions released by parting lips,producing noise burst.\n";
        String lessonConsonantD = "-The front and sides of the tongue contact the alveolar ridge anteriorly and laterally.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are adducted and vibrating.\n" +
                "\r\n-Air pressure build up behind obstructions is released by lowering the tongue,producing noise burst.\n";
        String lessonConsonantdz = "-The front and sides of the tongue contact the alveolar ridge anteriorly and laterally.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are abducted.\n" +
                "\r\n-Air pressure built upbehind obstruction is released by lowering the tongue,and is followed by frictional noise associated with fricative portion of the sound.]\n";
        String lessonConsonantG = "-The tongue dorsum is elevated and retracted to contact the back of the had palate and the soft palate,depending on phonetic context.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are abducted and vibrating.\n" +
                "\r\n-Air pressure built up behind obstraction is released by lowering the tongue,ptoducing noise burst.";
        String lessonConsonantV = "-The inner bolder of the lower lip contacts the upper teeth to create a constriction.\n" +
                "\r\n-Tongue position may vary depending on phonetic.\n" +
                "\r\n-Air forced through the lower lip and upper teth constriction creates audible frictional turbulence.";
        String lessonStrongTh = "-Tongue tips is brought forward just beloaw the upper teach or into slight contact with back of the upper teeth to create a construction beetwen the tongue and database.\n" +
                "\r\n-The vocal folds are abducted and vibrating. \n" +
                "\r\n-Air forced between tongue surface and the cutting edge of the upper teeth ir inside surface of the teeth,create audible frictional turburlence.\n";
        String lessonConsonantZ = "-The apex and blade of the tongue are elevated into contact with the hard palate,leaving a narrow midline groove open.\n" +
                "\r\n-The tongue may tip may be rasied or lowered behind the upper teeth.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are abducted and vibrating.\n";
        String lessonConsonantZO = "-The tip and blade of the tongue is elevated into contact with the sides of the palate and teeth,leaving a flattened midline groove along the upper surface of the tongue.\n" +
                "\r\n-The lips may be slightly rounded and protruded,but the degree varies with phonetic context.\n" +
                "\r\n-The vocal are abducted.\n" +
                "\r\n-Air forcedunder pressure along the flattern midline groove and across the teeth creates audible frictional turbulence.\n";
        String lessonVoicelessConsonantP = "-The lips are brought together to obstruct oral cavity.\n " +
                "\r\n-Tongue position may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are abducted.\n" +
                "\r\n-The velopharyngenal port is closed.\n" +
                "\r\n-Air pressure buit up behind obstruction is released by parting lips,producing noise burst.\n";
        String lessonVoicelessConsonantT = "-The front and sides of the tongue contact the alveolar ridge anteriorly and laterally.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The velopharyngenal port is closed.\n" +
                "\r\n-The vocal folds are abducted.\n" +
                "\r\n-Air pressure buit up behind obstruction is released by lowering the tongue,producing noise burst.";
        String lessonConsonantCh = "-The front and sides of the tongue contact the alveolar ridge anteriorly and laterally.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The velopharyngenal port is closed.\n" +
                "\r\n-The vocal folds are abducted.\n" +
                "\r\n-Air pressure built up behind obstruction is realeses by lowering the tongue,and is followed by frictional noise associated with fricative portion of the sound.\n";
        String lessonConsonantK = "-The tongue dorsum is elevated and retracted to contact the back of the hard palate and the soft palate,depending on phonetic context.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The velopharyngenal port is closed.\n" +
                "\r\n-The vocal folds are abducted.\n" +
                "\r\n-Air pressure buit up behind obstruction is released by lowering tongue,producing noise burst.\n";
        String lessonConsonantF = "-The inner border of the lower tip contacts the upper teeth to create a constriction.\n" +
                "\r\n-Tongue position may vary depending on phonetic context.\n" +
                "\r\n-The velopharyngenal port is closed.\n" +
                "\r\n-The vocal folds are abducted.\n" +
                "\r\n-Air forced through the lower lip/upper teeth constriction creates audible frictional turbulence.\n";
        String lessonConsonantTH = "-Tongue tip is brought forward just below the upper teeth(iterdental) or into slight contact with the back of the upper teeth to create a construction between the tongue tip and upper teeth.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The velopharyngenal port is closed.\n" +
                "\r\n-The vocal folds are abducted.\n" +
                "\r\n-Air forced between tongue surface and cutting edge of the upper teeth or inside surface of the teeth creates audible frictional turblunce";
        String lessonConsonatS = "-The apex and blade of the tongue are elevated into contact with the hard palate,leaving a narrow midline groove open.\n" +
                "\r\n-The tongue tip may be raised or lowered behind the upper teeth.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The velopharyngenal port is closed.\n";
        String lessonConsonantSH = "-The tip and blade of the tongue are elevated into contact with the sideso f the palate and teeth,leaving" +
                "a flattened midline groove along the upper surface of the tongue.\n" +
                "\r\n-The lips may be slightly rounded and producted,but the degree varies with phonetic context.\n" +
                "\r\n-The vocal folds are abducted.\n" +
                "\r\n-The velopharyngenal port is closed.\n" +
                "\r\n-Air forced under pressure along the flattened midline groove and across the teeth creates audible frictional turbulence.\n";
        String lessonConsonantM = "-The lips are brought  together to obstruct the oral cavity.\n" +
                "\r\n-Tongue position may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are abducted and vibrating.\n" +
                "\r\n-The velopharyngenal port is open,allowing acoustic energy and airflow to pass through the nose.\n";
        String lessonConsonantN = "-The front and sides of the tongue contact the alveolar ridge anteriorly and laterally to obstruct the oral cavity.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are abducted and vibrating.\n" +
                "\r\n-The velopharyngenal port is open,allowing acoustic energy and airflow to pass through the nose.\n";
        String lessonConsonantNG = "-The tongue dorsum is elevated and retracted to contact the soft palate,obstructing the oral cavity.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are abducted and vibrating.\n" +
                "\r\n-The vocal folds are abducted and vibrating.";
        String lessonConsonantH = "-The vocals fold are partially abducted to create a narrowing of the airway.\n" +
                "\r\n-Lip and tongue configuration varies depending on phonetic context.\n" +
                "\r\n-The velopharyngenal port is closed.\n" +
                "\r\n-Air forced under pressure through the laryngeal narrowing creates audible frictional turbulence.\n";
        String lessonConsonantL = "-The tongue tip and a portion of the tongue blade contact the alveolar ridge in the midline.\n" +
                "-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are abducted and vibrating.\n" +
                "\r\n-The velopharyngenal port is closed.\n" +
                "\r\n-Acoustic energy radiates laterally,aroundmidline closure.\n";
        String lessonConsonantR = "-The tongue is elevated towards the hard palate in a bunched configuration.\n" +
                "\r\n-The front of the tongue is usually close to the alveolar ridge but may be retroflexed.\n" +
                "\r\n-The lips are slightly unrounded.\n" +
                "\r\n-The vocal folds are abducted and vibrating.\n" +
                "\r\n-The velopharyngeal port is closed.\n";
        String lessonConsonatW = "-The tongue begins in a high back position similar to the vowel /u/,but the airways" +
                "are slightly more constricted .\n" +
                "\r\n-The tongue glides from its start position to a more open position for the following vowel.Lips are rounded and protruded" +
                ",then move to the configuration for the following vowel.\n" +
                "\r\n-The vocal folds are abducted and vibrating.\n" +
                "\r\n-The velopharyngeal port is closed.\n";
        String lessonConsonantJ = "-The tongue begin in a high front position similar to the vowel /I/," +
                "but the airway is slightly more constricted.\n" +
                "\r\n-The tongue glides from its start position to a more open position for the following vowel.\n" +
                "\r\n-Lip configuration may vary depending on phonetic context.\n" +
                "\r\n-The vocal folds are abducted and vibrating.\n" +
                "\r\n-The velopharyngeal port is closed.\n";
        SoundLessonRule.put("01", lessonIORule);
        SoundLessonRule.put("02", lessonUORule);
        SoundLessonRule.put("03", lessonAIRule);
        SoundLessonRule.put("04", lessonOIRule);
        SoundLessonRule.put("05", lessonOURule);
        SoundLessonRule.put("06", lessonEORule);
        SoundLessonRule.put("07", lessonAURule);
        SoundLessonRule.put("08", lessonEIRule);
        SoundLessonRule.put("09", lessonLongIRule);
        SoundLessonRule.put("10", lessonLongURule);
        SoundLessonRule.put("11", lessonLongARule);
        SoundLessonRule.put("12", lessonLongORule);
        SoundLessonRule.put("13", lessonLongERule);
        SoundLessonRule.put("14", lessonShortIRule);
        SoundLessonRule.put("15", lessonShortURule);
        SoundLessonRule.put("16", lessonShortARule);
        SoundLessonRule.put("17", lessonShortORule);
        SoundLessonRule.put("18", lessonShortOWRule);
        SoundLessonRule.put("19", lessonShortERule);
        SoundLessonRule.put("20", lessonShortAERule);
        SoundLessonRule.put("21", lessonConsonantB);
        SoundLessonRule.put("22", lessonConsonantD);
        SoundLessonRule.put("23", lessonConsonantdz);
        SoundLessonRule.put("24", lessonConsonantG);
        SoundLessonRule.put("25", lessonConsonantV);
        SoundLessonRule.put("26", lessonStrongTh);
        SoundLessonRule.put("27", lessonConsonantZ);
        SoundLessonRule.put("28", lessonConsonantZO);
        SoundLessonRule.put("29", lessonVoicelessConsonantP);
        SoundLessonRule.put("30", lessonVoicelessConsonantT);
        SoundLessonRule.put("31", lessonConsonantCh);
        SoundLessonRule.put("32", lessonConsonantK);
        SoundLessonRule.put("33", lessonConsonantF);
        SoundLessonRule.put("34", lessonConsonantTH);
        SoundLessonRule.put("35", lessonConsonatS);
        SoundLessonRule.put("36", lessonConsonantSH);
        SoundLessonRule.put("37", lessonConsonantM);
        SoundLessonRule.put("38", lessonConsonantN);
        SoundLessonRule.put("39", lessonConsonantNG);
        SoundLessonRule.put("40", lessonConsonantH);
        SoundLessonRule.put("41", lessonConsonantL);
        SoundLessonRule.put("42", lessonConsonantR);
        SoundLessonRule.put("43", lessonConsonatW);
        SoundLessonRule.put("44", lessonConsonantJ);
    }

    private void setStaticSyllableLessonRule() {
        String syllableLessonRule = "-Syllable is a unit of pronounciation that has one vowel sound,and may or may not be surrounded by consonants" +
                "\r\n-A syllable can form a whole word or a part of word.\n" +
                "\r\n-Every word is made from syllables.\n" +
                "\r\n-Each word has one,two or three or more syllable.";
        String wordStressLessonRule = "-With most nouns and adjectives with two syllables,the stress in on the first syllable.\n" +
                "\r\n-With most verbs with two syllable,the stress in on the last syllable.\n" +
                "\r\n-The word ending with -TION,-SION,-CIAN are usually stressed on the second last syllable.\n" +
                "\r\n-Words ending in -IC are usually stress on the second last syllable.\n" +
                "\r\n-Words ending in -EE and -OO are uasully stress on the last syllable.\n";
        String sentencesStressOrRythmLessonRule = "-Every language has its own music, or rhythm, so if you speak English with the music of your first language," +
                " others may have a hard time understanding you.\n" +
                "\r\n-The rhythm of English is created by stressing some words and de-stressing others.\n" +
                "\r\n1) We stress content words, which carry meaning in a sentence. These include:\n" +
                "\r\n-Noun;Main verb;Adjectives;Adverbs;Interjections;Wh-words;Negatives;\n" +
                "\r\n2) We also de-stress function words, typically little words, which are more about the grammar and structure of the sentence. These include:\n" +
                "\r\n-Prepositions;Pronouns;Articles;Conjunctions;Auxiliary verbs";
        String linkingLessonRule = "-When we say a sentence in English,we join or link words together.If you recognize and use linking," +
                "you will understand the others easily and make them understand you easily.\n" +
                "\r\nHere is some rule for linking word in sentence:\n" +
                "\r\n-Consonant<->Vowel:We link words end with a consonant sound to words beginning with a vowel sounds.\n" +
                "\r\n-Consonant<->Consonant:If the first word end with a consonant sound and the following word beginning with the same or similar sound," +
                "you should only pronounce the consonants sound once time.\n";
        OtherLessonRule.put(TopicActivity.SYLLABLE_LESSON, syllableLessonRule);
        OtherLessonRule.put(TopicActivity.WORD_STRESS_LESSON, wordStressLessonRule);
        OtherLessonRule.put(TopicActivity.LINKING, linkingLessonRule);
        OtherLessonRule.put(TopicActivity.SENTENCE_STRESS, sentencesStressOrRythmLessonRule);
    }

    private void setStaticWordExampleData() {
        setStaticDataWordIO();
        setStaticDataWordUO();
        setStaticDataWordAI();
        setStaticDataWordOI();
        setStaticDataWordOU();
        setStaticDataWordEO();
        setStaticDataWordAU();
        setStaticDataWordEI();
        setStaticDataWordLongI();
        setStaticDataWordLongU();
        setStaticDataWordLongA();
        setStaticDataWordLongO();
        setStaticDataWordLongE();
        setStaticDataWordShortI();
        setStaticDataWordShortU();
        setStaticDataWordShortA();
        setStaticDataWordShortO();
        setStaticDataWordShortOW();
        setStaticDataWordShortE();
        setStaticDataWordShortAE();
        setStaticDataWordB();
        setStaticDataWordD();
        setStaticDataWordDZ();
        setStaticDataWordG();
        setStaticDataWordV();
        setStaticDataWordStrongTH();
        setStaticDataWordZ();
        setStaticDataWordZO();
        setStaticDataWordP();
        setStaticDataWordT();
        setStaticDataWordCH();
        setStaticDataWordK();
        setStaticDataWordF();
        setStaticDataWordTH();
        setStaticDataWordS();
        setStaticDataWordSH();
        setStaticDataWordM();
        setStaticDataWordN();
        setStaticDataWordNG();
        setStaticDataWordH();
        setStaticDataWordH();
        setStaticDataWordL();
        setStaticDataWordR();
        setStaticDataWordW();
        setStaticDataWordJ();
    }

    private void setStaticWordStressLessonTitle() {
        ArrayList<SyllableLessonTitle> arrayStressLessonTitle = new ArrayList<SyllableLessonTitle>();
        SyllableLessonTitle lesson1 = new SyllableLessonTitle(1, "Word Stress");
        arrayStressLessonTitle.add(lesson1);
        StressLessonTitle.put(TopicActivity.WORD_STRESS_LESSON, arrayStressLessonTitle);
    }

    private void setStaticWordStressQuestionLesson1() {
        ArrayList<SyllableQuestion> arrayQuestion = new ArrayList<SyllableQuestion>();
        SyllableQuestion answer = new SyllableQuestion(1, R.raw.stress_lesson1_q1, "Listen and choose the word has diffrent stress pattern from the others", "answer  agree  allow  attract", new String[]{"answer", ""}, "answer", PracticeSyllableActivity.FILL);
        arrayQuestion.add(answer);
        SyllableQuestion mistake = new SyllableQuestion(2, R.raw.stress_lesson1_q2, "Listen and choose the word has diffrent stress pattern from the others", "middle  minute  mission  mistake", new String[]{"mistake", ""}, "mistake", PracticeSyllableActivity.FILL);
        arrayQuestion.add(mistake);
        SyllableQuestion copy = new SyllableQuestion(3, R.raw.stress_lesson1_q3, "Listen and choose the word has diffrent stress pattern from the others", "compare  correct  copy  collect", new String[]{"copy", ""}, "copy", PracticeSyllableActivity.FILL);
        arrayQuestion.add(copy);
        SyllableQuestion guitar = new SyllableQuestion(4, R.raw.stress_lesson1_q4, "Listen and choose the word has diffrent stress pattern from the others", "garden  granny  guitar  grammar", new String[]{"guitar", ""}, "guitar", PracticeSyllableActivity.FILL);
        arrayQuestion.add(guitar);
        SyllableQuestion complete = new SyllableQuestion(5, R.raw.stress_lesson1_q5, "Listen and choose the word has diffrent stress pattern from the others", "complete  common  careful  crazy", new String[]{"complete", ""}, "complete", PracticeSyllableActivity.FILL);
        arrayQuestion.add(complete);
        SyllableQuestion progressed = new SyllableQuestion(6, 0, "Choose the two-syllable word which stress on the second syllable", "You've progressed well this year,but I'd like to see even more progress", new String[]{"progressed", ""}, "progressed", PracticeSyllableActivity.FILL);
        arrayQuestion.add(progressed);
        SyllableQuestion builder = new SyllableQuestion(7, 0, "Choose the two-syllable word which stress on the first syllable", "I asked the builder to rebuild the wall", new String[]{"builder", "rebuild"}, "builder", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(builder);
        SyllableQuestion export = new SyllableQuestion(8, 0, "Choose the two-syllable word which stress on the first syllable", "We import too much petrol and the country's export figures are going down", new String[]{"import,export", "petrol,figures"}, "petrol,figures", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(export);
        SyllableQuestion record = new SyllableQuestion(9, 0, "Choose the two-syllable word which stress on the two syllable", "I will record a song and have a meeting with my friend tommorow", new String[]{"record", ""}, "record", PracticeSyllableActivity.FILL);
        arrayQuestion.add(record);
        SyllableQuestion procedure = new SyllableQuestion(10, 0, "Choose the two-syllable word which stress on the two syllable", "These companies produce household objects such as fridges and washing machines", new String[]{"produce", ""}, "produce", PracticeSyllableActivity.FILL);
        arrayQuestion.add(procedure);
        SyllableQuestion commfort = new SyllableQuestion(11, 0, "The stress in this couple of words:", "comfort-comfortable", new String[]{"first syllable-first syllable", "first syllable-second syllable"}, "first syllable-first syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(commfort);
        SyllableQuestion compete = new SyllableQuestion(12, 0, "The stress in this couple of words:", "compete-competition", new String[]{"second syllable-second syllable", "second syllable-third syllable"}, "second syllable-third syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(compete);
        SyllableQuestion automat = new SyllableQuestion(13, 0, "The stress in this couple of words:", "automat-automatic", new String[]{"first syllable-second syllable", "first syllable-third syllable"}, "first syllable-third syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(automat);
        SyllableQuestion educate = new SyllableQuestion(14, R.raw.stress_lesson3_q4, "Listen and choose correct answer", "The stress in this couple of words:", new String[]{"first syllable-second syllable", "first syllable-third syllable"}, "first syllable-third syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(educate);
        SyllableQuestion electric = new SyllableQuestion(15, R.raw.stress_lesson3_q5, "Listen and choose correct answer", "The stress in this couple of words:", new String[]{"second syllable-third syllable", "first syllable-third syllable"}, "second syllable-third syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(electric);
        SyllableQuestion scientist = new SyllableQuestion(16, R.raw.stress_lesson3_q6, "Listen and choose correct answer", "The stress in this couple of words:", new String[]{"second syllable-third syllable", "first syllable-third syllable"}, "first syllable-third syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(scientist);
        SyllableQuestion child = new SyllableQuestion(17, R.raw.stress_lesson3_q7, "Listen and choose correct answer", "The stress in this couple of words:", new String[]{"first syllable-first syllable", "first syllable-second syllable"}, "first syllable-first syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(child);
        SyllableQuestion romantic = new SyllableQuestion(18, 0, "Pronounce this word", "romantic", new String[]{"", ""}, "romantic", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(romantic);
        SyllableQuestion pronunciation = new SyllableQuestion(19, 0, "Pronounce this word", "pronunciation", new String[]{"", ""}, "pronunciation", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(pronunciation);
        SyllableQuestion musician = new SyllableQuestion(20, 0, "Pronounce this word", "musician", new String[]{"", ""}, "musician", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(musician);
        SyllableQuestion economy = new SyllableQuestion(21, 0, "The stress in this couple of words:", "economy-economical", new String[]{"second syllable-second syllable", "second syllable-third syllable"}, "second syllable-third syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(economy);
        SyllableQuestion nationality = new SyllableQuestion(22, 0, "The stress in this couple of words:", "nationality-nationalise", new String[]{"third syllable-first syllable", "third syllable-third syllable"}, "third syllable-first syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(nationality);
        SyllableQuestion human = new SyllableQuestion(23, 0, "The stress in this couple of words:", "human-humanity", new String[]{"first syllable-second syllable", "first syllable-first syllable"}, "first syllable-second syllable", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(human);
        SyllableQuestion sociology = new SyllableQuestion(24, R.raw.stress_lesson4_q4, "Listen and fill the word missing:", "society-.....-sociological", new String[]{"sociology", ""}, "sociology", PracticeSyllableActivity.FILL);
        arrayQuestion.add(sociology);
        SyllableQuestion civilization = new SyllableQuestion(25, R.raw.stress_lesson4_q5, "Listen and fill the word missing:", "civil-civilise-.....", new String[]{"civilization", ""}, "civilization", PracticeSyllableActivity.FILL);
        arrayQuestion.add(civilization);
        SyllableQuestion biology = new SyllableQuestion(26, R.raw.stress_lesson4_q6, "Listen and fill the word missing:", "....-biologist-biological", new String[]{"biology", ""}, "biology", PracticeSyllableActivity.FILL);
        arrayQuestion.add(biology);
        SyllableQuestion authority = new SyllableQuestion(27, 0, "Make a word ending in -ity from the word below and pronounce it", "author", new String[]{"", ""}, "authority", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(authority);
        SyllableQuestion university = new SyllableQuestion(28, 0, "Make a word ending in -ity from the word below and pronounce it", "universe", new String[]{"", ""}, "University", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(university);
        SyllableQuestion nation = new SyllableQuestion(29, 0, "Make a word ending in -ity from the word below and pronounce it", "nation", new String[]{"", ""}, "nationality", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(nation);
        SyllableQuestion person = new SyllableQuestion(30, 0, "Make a word ending in -ity from the word below and pronounce it", "person", new String[]{"", ""}, "personality", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(person);
        WordStressQuestionLesson.put(1, arrayQuestion);
    }

    private void setStaticSyllableLessonTitle() {
        ArrayList<SyllableLessonTitle> arraySyllableLessonOneTitle = new ArrayList<SyllableLessonTitle>();
        SyllableLessonTitle lesson1 = new SyllableLessonTitle(1, "Syllables In A Word");
        arraySyllableLessonOneTitle.add(lesson1);
        StressLessonTitle.put(TopicActivity.SYLLABLE_LESSON, arraySyllableLessonOneTitle);
    }

    private void setStaticSyllableQuestionLesson1() {
        ArrayList<SyllableQuestion> arrayQuestion = new ArrayList<SyllableQuestion>();
        SyllableQuestion walked = new SyllableQuestion(1, 0, "Number of syllable in this sentences: ", "I walked with my friend", new String[]{"six", "seven"}, "six", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(walked);
        SyllableQuestion helper = new SyllableQuestion(2, R.raw.lesson2_q2, "Hear and give the number of syllable in this sentences", "", new String[]{"six", "6"}, "six", PracticeSyllableActivity.FILL);
        arrayQuestion.add(helper);
        SyllableQuestion counted = new SyllableQuestion(3, 0, "Number of syllable in this sentences: ", "He counted the apple", new String[]{"five", "six"}, "six", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(counted);
        SyllableQuestion didnot = new SyllableQuestion(4, R.raw.lesson2_q3, "Hear and give the number of syllable in this sentences", "", new String[]{"five", "six"}, "six", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(didnot);
        SyllableQuestion waited = new SyllableQuestion(5, 0, "Number of syllable in this sentences: ", "He waited the train", new String[]{"five", "six"}, "five", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(waited);
        SyllableQuestion learnt = new SyllableQuestion(6, R.raw.lesson2_q4, "Hear and give the number of syllable in this sentences", "", new String[]{"4", "four"}, "four", PracticeSyllableActivity.FILL);
        arrayQuestion.add(learnt);
        SyllableQuestion danced = new SyllableQuestion(7, 0, "Number of syllable in this sentences: ", "He danced with me yesterday", new String[]{"six", "seven"}, "seven", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(danced);
        SyllableQuestion guess = new SyllableQuestion(8, R.raw.lesson2_q5, "Hear and give the number of syllable in this sentences", "", new String[]{"five", "four"}, "four", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(guess);
        SyllableQuestion cleaned = new SyllableQuestion(9, 0, "Number of syllable in this sentences: ", "He cleaned the house", new String[]{"five", "four"}, "four", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(cleaned);
        SyllableQuestion guests = new SyllableQuestion(10, R.raw.lesson3_q7, "Hear and give the number of syllable in this sentences", "", new String[]{"6", "six"}, "six", PracticeSyllableActivity.FILL);
        arrayQuestion.add(guests);
        SyllableQuestion beautiful = new SyllableQuestion(11, 0, "Number of syllable in this sentences: ", "Your garden is beautiful", new String[]{"six", "seven"}, "seven", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(beautiful);
        SyllableQuestion wishes = new SyllableQuestion(12, 0, "Pronounce the word has two syllable: ", "key,modify,wishes,intelligent", new String[]{"wishes", ""}, "wishes", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(wishes);
        SyllableQuestion arms = new SyllableQuestion(13, R.raw.lesson3_q8, "Listen and choose number of word has one syllable", "He broke his arm/arms in the accident", new String[]{"five", "six"}, "six", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(arms);
        SyllableQuestion glass = new SyllableQuestion(14, R.raw.lesson1_q1, "Hear and give the number of syllable in this sentences: ", "", new String[]{"four", "4"}, "four", PracticeSyllableActivity.FILL);
        arrayQuestion.add(glass);
        SyllableQuestion countQuestion1 = new SyllableQuestion(15, 0, "How many two-syllable word in this paragraph: ", "There are just certain people, for example one of my favorites, one of my favorite\n" +
                "teachers, he’s dead now but I think he’s a great example, I want to be like him", new String[]{"four", "three"}, "three", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(countQuestion1);
        SyllableQuestion song = new SyllableQuestion(16, R.raw.lesson3_q9, "Hear and give the number of syllable in this sentences: ", "", new String[]{"8", "eight"}, "eight", PracticeSyllableActivity.FILL);
        arrayQuestion.add(song);

        SyllableQuestion countQuestion2 = new SyllableQuestion(17, 0, "How many three-syllable word in this paragraph: ", "He’s ninety years old. He’s still super energetic. He exercises constantly. He\n" +
                "swims. He runs. He lifts weights. His wife also, they’re both like ninety‑something years\n" +
                "old and they’re just so strong and healthy", new String[]{"four", "three"}, "three", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(countQuestion2);
        SyllableQuestion bird = new SyllableQuestion(18, R.raw.lesson3_q6, "Listen and choose number of word has one syllable", "", new String[]{"five", "six"}, "six", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(bird);
        SyllableQuestion play = new SyllableQuestion(19, R.raw.lesson1_q2, "Hear and give the number of syllable in this sentences:", "", new String[]{"five", "six"}, "five", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(play);
        SyllableQuestion fright = new SyllableQuestion(20, R.raw.lesson1_q3, "Hear and give the number of syllable in this sentences:", "", new String[]{"seven", "7"}, "seven", PracticeSyllableActivity.FILL);
        arrayQuestion.add(fright);
        SyllableQuestion countQuestion3 = new SyllableQuestion(21, 0, "How many two-syllable word in this paragraph: ", "If the correlation between cancer and animal food consumption is\n" +
                "indeed powerful, you would expect many studies to find a\n" +
                "connection between the two. It turns out there are many", new String[]{"four", "five"}, "five", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(countQuestion3);
        SyllableQuestion house = new SyllableQuestion(22, 0, "How many two-syllable in this paragraph: ", "It looked like a mansion compared to our old house. It was a tall\n" +
                "redbrick house with a sloping black roof and rows of windows framed by black\n" +
                "shutters.", new String[]{"seven", "eight"}, "seven", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(house);
        SyllableQuestion beautiful2 = new SyllableQuestion(23, 0, "Pronounce the word have different number of syllables: ", "intelligent-beautiful-interesting-comfortable", new String[]{"beautiful", ""}, "beautiful", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(beautiful2);
        SyllableQuestion car = new SyllableQuestion(24, R.raw.lesson3_q10, "Hear and give the number of syllable in this sentences:", "", new String[]{"eight", "seven"}, "eight", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(car);
        SyllableQuestion cancer = new SyllableQuestion(25, 0, "How many two-syllable word in this sentence: ", "A high intake of fruits and\n" +
                "vegetables, on the other hand, was associated with a lower risk of\n" +
                "advanced prostate cancer.", new String[]{"4", "four"}, "four", PracticeSyllableActivity.FILL);
        arrayQuestion.add(cancer);
        SyllableQuestion comfortable = new SyllableQuestion(26, 0, "How many syllable in this sentence: ", "This apartment is really comfortable ", new String[]{"eleven", "11"}, "eleven", PracticeSyllableActivity.FILL);
        arrayQuestion.add(comfortable);
        SyllableQuestion china = new SyllableQuestion(27, 0, "How many two-syllable word in this sentence: ", "Today, men in China who are still eating their\n" +
                "traditional plant‑based diet without any dairy products have one of\n" +
                "the lowest rates of prostate cancer in the world.", new String[]{"eleven", "ten"}, "ten", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(china);
        SyllableQuestion intelligent = new SyllableQuestion(28, 0, "How many syllable in this sentence: ", "Her brother is the most intelligent people I have seen ", new String[]{"fifteen", "fourteen"}, "fifteen", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(intelligent);
        SyllableQuestion belief = new SyllableQuestion(29, 0, "How many two-syllable word in this sentence: ", "Your global beliefs affect all your other beliefs. They\n" +
                "influence all your other beliefs. They influence all of your other emotions. They\n" +
                "influence everything. ", new String[]{"four", "five"}, "four", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(belief);
        SyllableQuestion wonderful = new SyllableQuestion(30, 0, "How many syllable in this sentence: ", "Going to the beach is wonderful idea ", new String[]{"eleven", "11"}, "eleven", PracticeSyllableActivity.FILL);
        arrayQuestion.add(wonderful);

        SyllableQuestionLesson.put(1, arrayQuestion);

    }

    private void setStaticSentenceStressTitle() {
        ArrayList<SyllableLessonTitle> arrayWordStressLessonTitle = new ArrayList<SyllableLessonTitle>();
        SyllableLessonTitle lesson1 = new SyllableLessonTitle(1, "Sentence Stress And Intonation");
        arrayWordStressLessonTitle.add(lesson1);
        StressLessonTitle.put(TopicActivity.SENTENCE_STRESS, arrayWordStressLessonTitle);
    }

    private void setStaticSentenceStressQuestion() {
        ArrayList<SyllableQuestion> arrayQuestion = new ArrayList<SyllableQuestion>();
        SyllableQuestion straight = new SyllableQuestion(1, 0, "Choose the sentence we will put stress in all word", "", new String[]{"Go straight on!", "The sky is blue"}, "Go straight on!", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(straight);
        SyllableQuestion late = new SyllableQuestion(2, R.raw.sentence_stress_q1, "Hear and give the sentence your hear", "", new String[]{"Don't be late!.Go away!", "Don't be late.Go away"}, "Don't be late!.Go away!", PracticeSyllableActivity.FILL);
        arrayQuestion.add(late);
        SyllableQuestion round = new SyllableQuestion(3, 0, "Choose the sentence we will put stress in all word", "", new String[]{"It is really wonderful", "Don't turn round!"}, "Don't turn round!", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(round);
        SyllableQuestion stay = new SyllableQuestion(4, R.raw.sentence_stress_q4, "How many word stressed in these sentences you hear", "", new String[]{"four", "nine"}, "nine", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(stay);
        SyllableQuestion wakeup = new SyllableQuestion(5, 0, "Choose the sentence we will put stress in all word", "", new String[]{"I will meet you tommorrow", "Wake up!"}, "Wake up!", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(wakeup);
        SyllableQuestion lookdown = new SyllableQuestion(6, R.raw.sentence_stress_q2, "Hear and give the sentence your hear", "Don't look down!.__________", new String[]{"Go straight on!", "Go straight on"}, "Go straight on", PracticeSyllableActivity.FILL);
        arrayQuestion.add(lookdown);
        SyllableQuestion quiet = new SyllableQuestion(7, R.raw.sentence_stress_q3, "Hear and give the sentence your hear", "", new String[]{"Keep quiet!.Don't worry!", "Keep quiet.Don't worry"}, "Keep quiet!.Don't worry!", PracticeSyllableActivity.FILL);
        arrayQuestion.add(quiet);
        SyllableQuestion your = new SyllableQuestion(8, 0, "What word you will unstress in this sentence", "What's your name", new String[]{"your", ""}, "your", PracticeSyllableActivity.FILL);
        arrayQuestion.add(your);
        SyllableQuestion takecare = new SyllableQuestion(9, R.raw.sentence_stress_q5, "How many word stressed in these sentences you hear", "", new String[]{"seven", "eight"}, "eight", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(takecare);
        SyllableQuestion eat = new SyllableQuestion(10, R.raw.sentence_stress_q5, "How many word stressed in these sentences you hear", "", new String[]{"four", "five"}, "four", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(eat);
        SyllableQuestion tell = new SyllableQuestion(11, R.raw.sentence_stress_q19, "Hear and give the sentence your hear", "", new String[]{"Can you tell her to call me please?", "Can you tell her to call me please"}, "Can you tell her to call me please", PracticeSyllableActivity.FILL);
        arrayQuestion.add(tell);
        SyllableQuestion daughter = new SyllableQuestion(12, R.raw.sentence_stress_q21, "Hear and fill the blank", "Did____________,Catherine?", new String[]{"you meet the daughter", ""}, "you meet the daughter", PracticeSyllableActivity.FILL);
        arrayQuestion.add(daughter);
        SyllableQuestion egg = new SyllableQuestion(13, R.raw.sentence_stress_q30, "Hear and choose the world you hear", "Give her an/some egg if she's hungry", new String[]{"an", "some"}, "an", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(egg);
        SyllableQuestion give = new SyllableQuestion(14, R.raw.sentence_stress_q20, "Hear and give the sentence your hear", "", new String[]{"Can you give it to them please?", "Can you give it to them please"}, "Can you give it to them please", PracticeSyllableActivity.FILL);
        arrayQuestion.add(give);
        SyllableQuestion likeher = new SyllableQuestion(15, R.raw.sentence_stress_q22, "Hear and give the sentence your hear", "", new String[]{"I don't think he like her", ""}, "I don't think he like her", PracticeSyllableActivity.FILL);
        arrayQuestion.add(likeher);
        SyllableQuestion say = new SyllableQuestion(16, R.raw.sentence_stress_q23, "Hear and give the sentence your hear", "", new String[]{"What did she say to them?", "What did she say to them"}, "What did she say to them?", PracticeSyllableActivity.FILL);
        arrayQuestion.add(say);
        SyllableQuestion think = new SyllableQuestion(17, 0, "Choose the word will be stressed in this sentence.Seperate word with ;", "What do you think?", new String[]{"What;think", ""}, "What;think", PracticeSyllableActivity.FILL);
        arrayQuestion.add(think);
        SyllableQuestion guitar = new SyllableQuestion(18, R.raw.sentence_stress_q24, "Hear and give the sentence your hear", "", new String[]{"Where did she buy the guitar? ", "Where did she buy the guitar"}, "Where did she buy the guitar?", PracticeSyllableActivity.FILL);
        arrayQuestion.add(guitar);
        SyllableQuestion bird = new SyllableQuestion(19, 0, "Pronounce this sentence ", "the birds are singing", new String[]{"", ""}, "the birds are singing", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(bird);
        SyllableQuestion mother = new SyllableQuestion(20, R.raw.sentence_stress_q25, "Hear and give the sentence your hear", "", new String[]{"What his mother's name?", "What his mother's name"}, "What his mother's name?", PracticeSyllableActivity.FILL);
        arrayQuestion.add(mother);
        SyllableQuestion giveittome = new SyllableQuestion(21, 0, "Pronounce this sentence ", "Can you give it to me please?", new String[]{"", ""}, "can you give it to me please", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(giveittome);
        SyllableQuestion children = new SyllableQuestion(22, R.raw.sentence_stress_q27, "Hear and give the sentence your hear", "", new String[]{"We bought presents for our children", ""}, "We bought presents for our children", PracticeSyllableActivity.FILL);
        arrayQuestion.add(children);
        SyllableQuestion straighton = new SyllableQuestion(23, 0, "Pronounce this sentence ", "Go straight on!", new String[]{"", ""}, "go straight on", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(straighton);
        SyllableQuestion work = new SyllableQuestion(24, R.raw.sentence_stress_q26, "Hear and give the sentence your hear", "What do you think?", new String[]{"Where are your parents from?", "Where are your parents from"}, "Where are your parents from?", PracticeSyllableActivity.FILL);
        arrayQuestion.add(work);
        SyllableQuestion course = new SyllableQuestion(25, R.raw.sentence_stress_q29, "Hear and choose the world you hear", "I had a salad as/and a main course", new String[]{"as", "and"}, "and", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(course);
        SyllableQuestion look = new SyllableQuestion(26, R.raw.sentence_stress_q31, "Hear and choose the world you hear", "She went to look at/for the fruit", new String[]{"at", "for"}, "for", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(look);
        SyllableQuestion basket = new SyllableQuestion(27, R.raw.sentence_stress_q32, "Hear and choose the world you hear", "He gave me a basket of/for bread", new String[]{"of", "for"}, "for", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(basket);
        SyllableQuestion want = new SyllableQuestion(28, 0, "Pronounce this sentence ", "What do you want?", new String[]{"", ""}, "what do you want", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(want);
        SyllableQuestion pasta = new SyllableQuestion(29, R.raw.sentence_stress_q33, "Hear and choose the world you hear", "Get  some pasta and/or rice", new String[]{"and", "or"}, "and", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(pasta);
        SyllableQuestion beanAndRice = new SyllableQuestion(30, 0, "Pronounce this sentence ", "We has beans and rice ", new String[]{"", ""}, "we has beans and rice", PracticeSyllableActivity.SPEAK);
        arrayQuestion.add(beanAndRice);
        SentenceStressQuestion.put(1, arrayQuestion);
    }

    private void setStaticLinkingLessonTitle() {
        ArrayList<SyllableLessonTitle> arrayLinkingLessonOneTitle = new ArrayList<SyllableLessonTitle>();
        SyllableLessonTitle lesson1 = new SyllableLessonTitle(1, "Linking And Connected Speech");
        arrayLinkingLessonOneTitle.add(lesson1);
        StressLessonTitle.put(TopicActivity.LINKING, arrayLinkingLessonOneTitle);
    }

    private void setStaticLinkingQuestion() {
        ArrayList<SyllableQuestion> arrayQuestion = new ArrayList<SyllableQuestion>();
        SyllableQuestion petcenter = new SyllableQuestion(1, R.raw.linking_sentence_q1, "Listen and give the phrase sound the same with the phrase below", "pet center", new String[]{"pets enter", ""}, "pets enter", PracticeSyllableActivity.FILL);
        arrayQuestion.add(petcenter);
        SyllableQuestion stop = new SyllableQuestion(2, R.raw.linking_sentence_q2, "Listen and give the phrase sound the same with the phrase below", "stopped aching", new String[]{"stop taking", ""}, "stop taking", PracticeSyllableActivity.FILL);
        arrayQuestion.add(stop);
        SyllableQuestion icecream = new SyllableQuestion(3, R.raw.linking_sentence_q3, "Listen and give the phrase sound the same with the phrase below", "I scream", new String[]{"ice cream", ""}, "ice cream", PracticeSyllableActivity.FILL);
        arrayQuestion.add(icecream);
        SyllableQuestion noname = new SyllableQuestion(4, R.raw.linking_sentence_q4, "Listen and give the phrase sound the same with the phrase below", "no name", new String[]{"known aim", ""}, "known aim", PracticeSyllableActivity.FILL);
        arrayQuestion.add(noname);
        SyllableQuestion callDanny = new SyllableQuestion(5, R.raw.linking_sentence_q5, "Listen and give the phrase sound the same with the phrase below", "called Annie", new String[]{"call Danny", "call danny"}, "call Danny", PracticeSyllableActivity.FILL);
        arrayQuestion.add(callDanny);
        SyllableQuestion clockstop = new SyllableQuestion(6, R.raw.linking_sentence_q6, "Listen and give the phrase sound the same with the phrase below", "clock stop", new String[]{"clocks top", ""}, "clocks top", PracticeSyllableActivity.FILL);
        arrayQuestion.add(clockstop);
        SyllableQuestion mrknight = new SyllableQuestion(7, R.raw.linking_sentence_q7, "Listen and give the phrase sound the same with the phrase below", "Mr Knight", new String[]{"missed a night", ""}, "missed a night", PracticeSyllableActivity.FILL);
        arrayQuestion.add(mrknight);
        SyllableQuestion gotup = new SyllableQuestion(8, R.raw.linking_sentence_q8, "Listen and give the phrase you hear", "", new String[]{"Got up at eight", "Got up at eight"}, "Got up at eight", PracticeSyllableActivity.FILL);
        arrayQuestion.add(gotup);
        SyllableQuestion goton = new SyllableQuestion(9, R.raw.linking_sentence_q9, "Listen and give the phrase you hear", "", new String[]{"Got on a bus", ""}, "Got on a bus", PracticeSyllableActivity.FILL);
        arrayQuestion.add(goton);
        SyllableQuestion went = new SyllableQuestion(10, R.raw.linking_sentence_q10, "Listen and give the phrase you hear", "", new String[]{"went into work", ""}, "went into work", PracticeSyllableActivity.FILL);
        arrayQuestion.add(went);
        SyllableQuestion worked = new SyllableQuestion(11, R.raw.linking_sentence_q11, "Listen and give the phrase you hear", "", new String[]{"worked until two", ""}, "worked until two", PracticeSyllableActivity.FILL);
        arrayQuestion.add(worked);
        SyllableQuestion wentout = new SyllableQuestion(12, R.raw.linking_sentence_q12, "Listen and give the phrase you hear", "", new String[]{"went out for lunch", ""}, "went out for lunch", PracticeSyllableActivity.FILL);
        arrayQuestion.add(wentout);
        SyllableQuestion workedsix = new SyllableQuestion(13, R.raw.linking_sentence_q13, "Listen and give the phrase you hear", "", new String[]{"worked until six", ""}, "worked until six", PracticeSyllableActivity.FILL);
        arrayQuestion.add(workedsix);
        SyllableQuestion backbus = new SyllableQuestion(14, R.raw.linking_sentence_q14, "Listen and give the phrase you hear", "", new String[]{"back on the bus", ""}, "back on the bus", PracticeSyllableActivity.FILL);
        arrayQuestion.add(backbus);
        SyllableQuestion swithched = new SyllableQuestion(15, R.raw.linking_sentence_q15, "Listen and give the phrase you hear", "", new String[]{"switched on the box", ""}, "switched on the boxs", PracticeSyllableActivity.FILL);
        arrayQuestion.add(swithched);
        SyllableQuestion sleptchair = new SyllableQuestion(16, R.raw.linking_sentence_q16, "Listen and give the phrase you hear", "", new String[]{"slept in a chair", ""}, "slept in a chair", PracticeSyllableActivity.FILL);
        arrayQuestion.add(sleptchair);
        SyllableQuestion oldman = new SyllableQuestion(17, R.raw.linking_sentence_q17, "How many position are linked in this sentence", "", new String[]{"four", "three"}, "four", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(oldman);
        SyllableQuestion egg = new SyllableQuestion(18, R.raw.linking_sentence_q18, "How many position are linked in this sentence", "", new String[]{"five", "four"}, "four", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(egg);
        SyllableQuestion afterrate = new SyllableQuestion(19, R.raw.linking_sentence_q19, "Listen and give the phrase sound the same with the phrase below", "after eight", new String[]{"after rate", ""}, "after rate", PracticeSyllableActivity.FILL);
        arrayQuestion.add(afterrate);
        SyllableQuestion foureyes = new SyllableQuestion(20, R.raw.linking_sentence_q20, "Listen and give the phrase sound the same with the phrase below", "four eyes", new String[]{"four rise", ""}, "four rise", PracticeSyllableActivity.FILL);
        arrayQuestion.add(foureyes);
        SyllableQuestion clearair = new SyllableQuestion(21, R.raw.linking_sentence_q21, "Listen and give the phrase sound the same with the phrase below", "clear race", new String[]{"clear air", ""}, "clear air", PracticeSyllableActivity.FILL);
        arrayQuestion.add(clearair);
        SyllableQuestion everyyear = new SyllableQuestion(22, R.raw.linking_sentence_q22, "Listen and give the phrase sound the same with the phrase below", "every ear", new String[]{"every year", ""}, "every year", PracticeSyllableActivity.FILL);
        arrayQuestion.add(everyyear);
        SyllableQuestion earns = new SyllableQuestion(23, R.raw.linking_sentence_q23, "Listen and give the phrase sound the same with the phrase below", "He years", new String[]{"He earns", ""}, "He earns", PracticeSyllableActivity.FILL);
        arrayQuestion.add(earns);
        SyllableQuestion ache = new SyllableQuestion(24, R.raw.linking_sentence_q24, "Listen and give the phrase sound the same with the phrase below", "you ache", new String[]{"you wake", ""}, "you wake", PracticeSyllableActivity.FILL);
        arrayQuestion.add(ache);
        SyllableQuestion badyear = new SyllableQuestion(25, R.raw.linking_sentence_q25, "Listen and complete the sentence", "We had a _______", new String[]{"bad year", "badge"}, "bad year", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(badyear);
        SyllableQuestion shot = new SyllableQuestion(26, R.raw.linking_sentence_q26, "Listen and complete the sentence", "They _____ bears", new String[]{"shot", "shop"}, "shot", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(shot);
        SyllableQuestion shotcat = new SyllableQuestion(27, R.raw.linking_sentence_q27, "Listen and complete the sentence", "They _____ cats", new String[]{"shock", "shot"}, "shot", PracticeSyllableActivity.CHOOSE);
        arrayQuestion.add(shotcat);
        SyllableQuestion called = new SyllableQuestion(28, R.raw.linking_sentence_q28, "Listen and give the sentence", "", new String[]{"What's your son called?", "What is your son called?"}, "", PracticeSyllableActivity.FILL);
        arrayQuestion.add(called);
        SyllableQuestion sonmade = new SyllableQuestion(29, R.raw.linking_sentence_q29, "Listen and give the sentence", "", new String[]{"My son made this", "my son made this"}, "My son made this", PracticeSyllableActivity.FILL);
        arrayQuestion.add(sonmade);
        SyllableQuestion talk = new SyllableQuestion(30, R.raw.linking_sentence_q30, "Listen and give the sentence", "", new String[]{"I taught classes this morning", ""}, "I taught classes this morning", PracticeSyllableActivity.FILL);
        arrayQuestion.add(talk);
        LinkingQuestion.put(1, arrayQuestion);

    }

    private void setStaticDataWordUO() {
        ArrayList<WordData> arrayWordUO = new ArrayList<WordData>();
        WordData truer = new WordData("trʊər", "30420242", "truer", "02");
        arrayWordUO.add(truer);
        WordData sure = new WordData("ʃʊə", "3602", "sure", "02");
        arrayWordUO.add(sure);
        WordData bluer = new WordData("blʊər", "21410242", "bluer", "02");
        arrayWordUO.add(bluer);
        WordData tourist = new WordData("tʊərɪst", "300242143530", "tourist", "02");
        arrayWordUO.add(tourist);
        WordData poor = new WordData("pʊə", "2902", "poor", "02");
        arrayWordUO.add(poor);
        WordData jury = new WordData("dʒʊərɪ", "23024214", "jury", "02");
        arrayWordUO.add(jury);
        WordData cure = new WordData("kjʊə", "324402", "cure", "02");
        arrayWordUO.add(cure);
        WordExampleHashMap.put("02", arrayWordUO);

    }

    private void setStaticDataWordIO() {
        ArrayList<WordData> arrayWordIO = new ArrayList<WordData>();
        WordData beer = new WordData("bɪər", "210142", "beer", "01");
        arrayWordIO.add(beer);
        WordData near = new WordData("nɪər", "380142", "near", "01");
        arrayWordIO.add(near);
        WordData here = new WordData("hɪər", "400142", "here", "01");
        arrayWordIO.add(here);
        WordData clear = new WordData("klɪər", "32410142", "clear", "01");
        arrayWordIO.add(clear);
        WordData dear = new WordData("dɪər", "220142", "dear", "01");
        arrayWordIO.add(dear);
        WordData fear = new WordData("fɪər", "330142", "fear", "01");
        arrayWordIO.add(fear);
        WordData area = new WordData("eərɪə", "19184201", "area", "01");
        arrayWordIO.add(area);
        WordData tear = new WordData("tɪər", "300142", "tear", "01");
        arrayWordIO.add(tear);
        WordData cheer = new WordData("tʃɪər", "310142", "cheer", "01");
        arrayWordIO.add(cheer);
        WordData gearless = new WordData("gɪəlɪs", "2401411435", "gearless", "01");
        arrayWordIO.add(gearless);
        WordData beard = new WordData("bɪərd", "21014222", "beard", "01");
        arrayWordIO.add(beard);
        WordExampleHashMap.put("01", arrayWordIO);
    }

    private void setStaticDataWordAI() {
        ArrayList<WordData> arrayWordAI = new ArrayList<WordData>();
        WordData whileWord = new WordData("waɪl", "430341", "while", "03");
        arrayWordAI.add(whileWord);
        WordData rice = new WordData("raɪs", "420335", "rice", "03");
        arrayWordAI.add(rice);
        WordData fine = new WordData("faɪn", "330338", "fine", "03");
        arrayWordAI.add(fine);
        WordData behind = new WordData("bɪhaɪd", "2114400322", "behind", "03");
        arrayWordAI.add(behind);
        WordData child = new WordData("tʃaɪld", "31034122", "child", "03");
        arrayWordAI.add(child);
        WordData client = new WordData("klaɪənt", "324103183830", "client", "03");
        arrayWordAI.add(client);
        WordData mind = new WordData("maɪnd", "37033822", "mind", "03");
        arrayWordAI.add(mind);
        WordData silent = new WordData("saɪlənt", "350341183830", "silent", "03");
        arrayWordAI.add(silent);
        WordData fight = new WordData("faɪt", "330330", "fight", "03");
        arrayWordAI.add(fight);
        WordExampleHashMap.put("03", arrayWordAI);

    }

    private void setStaticDataWordOI() {
        ArrayList<WordData> arrayWordOI = new ArrayList<WordData>();
        WordData boy = new WordData("bɔɪ", "2104", "boy", "04");
        arrayWordOI.add(boy);
        WordData coin = new WordData("kɔɪn", "320438", "coin", "04");
        arrayWordOI.add(coin);
        WordData foil = new WordData("fɔɪl", "330441", "foil", "04");
        arrayWordOI.add(foil);
        WordData voice = new WordData("vɔɪs", "250435", "voice", "04");
        arrayWordOI.add(voice);
        WordData enjoy = new WordData("ɪndʒɔɪ", "14382304", "enjoy", "04");
        arrayWordOI.add(enjoy);
        WordData oil = new WordData("ɔɪl", "0441", "oil", "04");
        arrayWordOI.add(oil);
        WordData boil = new WordData("bɔɪl", "210441", "boil", "04");
        arrayWordOI.add(boil);
        WordData destroy = new WordData("dɪstrɔɪ", "221435304204", "destroy", "04");
        arrayWordOI.add(destroy);
        WordData point = new WordData("pɔɪnt", "29043830", "point", "04");
        arrayWordOI.add(point);
        WordData noise = new WordData("nɔɪz", "380427", "noise", "04");
        arrayWordOI.add(noise);
        WordExampleHashMap.put("04", arrayWordOI);


    }

    private void setStaticDataWordOU() {
        ArrayList<WordData> arrayWordOU = new ArrayList<WordData>();
        WordData load = new WordData("ləʊd", "410522", "load", "05");
        arrayWordOU.add(load);
        WordData pole = new WordData("pəʊl", "290541", "pole", "05");
        arrayWordOU.add(pole);
        WordData coat = new WordData("kəʊt", "320530", "coat", "05");
        arrayWordOU.add(coat);
        WordData boat = new WordData("bəʊt", "210530", "boat", "05");
        arrayWordOU.add(boat);
        WordData cold = new WordData("kəʊld", "32054122", "cold", "05");
        arrayWordOU.add(cold);
        WordData comb = new WordData("kəʊb", "320521", "comb", "05");
        arrayWordOU.add(comb);
        WordData though = new WordData("ðəʊ", "2605", "though", "05");
        arrayWordOU.add(though);
        WordData thorough = new WordData("θʌrəʊ", "34164205", "thorough", "05");
        arrayWordOU.add(thorough);
        WordData bowl = new WordData("bəʊl", "210541", "bowl", "05");
        arrayWordOU.add(bowl);
        WordData old = new WordData("əʊld", "054122", "old", "05");
        arrayWordOU.add(old);
        WordExampleHashMap.put("05", arrayWordOU);


    }

    private void setStaticDataWordEO() {
        ArrayList<WordData> arrayWordEO = new ArrayList<WordData>();
        WordData share = new WordData("ʃeə", "3606", "share", "06");
        arrayWordEO.add(share);
        WordData fair = new WordData("feə", "3306", "fair", "06");
        arrayWordEO.add(fair);
        WordData square = new WordData("skweə", "35324306", "square", "06");
        arrayWordEO.add(square);
        WordData where = new WordData("weə", "4306", "where", "06");
        arrayWordEO.add(where);
        WordData stair = new WordData("steə", "353006", "stair", "06");
        arrayWordEO.add(stair);
        WordData careful = new WordData("keəfʊl", "3206331541", "careful", "06");
        arrayWordEO.add(careful);
        WordData wearable = new WordData("weərəbl", "430642182141", "wearable", "06");
        arrayWordEO.add(wearable);
        WordData chair = new WordData("tʃeə", "3106", "chair", "06");
        arrayWordEO.add(chair);
        WordData barely = new WordData("beəlɪ", "21064114", "barely", "06");
        arrayWordEO.add(barely);
        WordData declare = new WordData("dɪkleə", "2214324106", "declare", "06");
        arrayWordEO.add(declare);
        WordExampleHashMap.put("06", arrayWordEO);

    }

    public void setStaticDataWordAU() {
        ArrayList<WordData> arrayWordAU = new ArrayList<WordData>();
        WordData cow = new WordData("kaʊ", "3207", "cow", "07");
        arrayWordAU.add(cow);
        WordData house = new WordData("haʊs", "400735", "house", "07");
        arrayWordAU.add(house);
        WordData nowaday = new WordData("naʊədeɪ", "38072208", "nowaday", "07");
        arrayWordAU.add(nowaday);
        WordData foul = new WordData("faʊl", "330741", "foul", "07");
        arrayWordAU.add(foul);
        WordData about = new WordData("əbaʊt", "18210730", "about", "07");
        arrayWordAU.add(about);
        WordData flower = new WordData("flaʊə", "33410718", "flower", "07");
        arrayWordAU.add(flower);
        WordData allow = new WordData("əlaʊ", "184107", "allow", "07");
        arrayWordAU.add(allow);
        WordData grown = new WordData("graʊn", "24420738", "grown", "07");
        arrayWordAU.add(grown);
        WordData brown = new WordData("braʊn", "21420738", "brown", "07");
        arrayWordAU.add(brown);
        WordData shout = new WordData("ʃaʊt", "360730", "shout", "07");
        arrayWordAU.add(shout);
        WordData cloud = new WordData("klaʊd", "32410722", "cloud", "07");
        arrayWordAU.add(cloud);
        WordExampleHashMap.put("07", arrayWordAU);


    }

    private void setStaticDataWordEI() {
        ArrayList<WordData> arrayWordEI = new ArrayList<WordData>();
        WordData pavement = new WordData("peɪvmənt", "290837183830", "pavement", "08");
        arrayWordEI.add(pavement);
        WordData shade = new WordData("ʃeɪd", "360822", "shade", "08");
        arrayWordEI.add(shade);
        WordData tail = new WordData("teɪl", "300841", "tail", "08");
        arrayWordEI.add(tail);
        WordData delay = new WordData("dɪleɪ", "22144108", "delay", "08");
        arrayWordEI.add(delay);
        WordData weight = new WordData("weɪt", "430830", "weight", "08");
        arrayWordEI.add(weight);
        WordData steak = new WordData("steɪk", "35300832", "steak", "08");
        arrayWordEI.add(steak);
        WordData face = new WordData("feɪs", "330835", "face", "08");
        arrayWordEI.add(face);
        WordData raise = new WordData("reɪz", "420827", "raise", "08");
        arrayWordEI.add(raise);
        WordData amaze = new WordData("əmeɪz", "18370827", "amaze", "08");
        arrayWordEI.add(amaze);
        WordData straight = new WordData("streɪt", "3530420830", "straight", "08");
        arrayWordEI.add(straight);
        WordData hate = new WordData("heɪt", "400830", "hate", "08");
        arrayWordEI.add(hate);
        WordData paper = new WordData("peɪpə", "29082918", "paper", "08");
        arrayWordEI.add(paper);
        WordExampleHashMap.put("08", arrayWordEI);


    }

    private void setStaticDataWordB() {
        ArrayList<WordData> arrayWordB = new ArrayList<WordData>();
        WordData black = new WordData("blæk", "21412032", "black", "21");
        arrayWordB.add(black);
        WordData job = new WordData("dʒɒb", "231721", "job", "21");
        arrayWordB.add(job);
        WordData bill = new WordData("bɪl", "211441", "bill", "21");
        arrayWordB.add(bill);
        WordData knob = new WordData("nɒb", "381721", "knob", "21");
        arrayWordB.add(knob);
        WordData bag = new WordData("bæg", "212024", "bag", "21");
        arrayWordB.add(bag);
        WordData bicycle = new WordData("baɪsɪkl", "210335143241", "bicycle", "21");
        arrayWordB.add(bicycle);
        WordData bandage = new WordData("bændɪdʒ", "212038221423", "badage", "21");
        arrayWordB.add(bandage);
        WordData bubble = new WordData("bʌbl", "21162141", "bubble", "21");
        arrayWordB.add(bubble);
        WordData label = new WordData("leɪbl", "41082141", "label", "21");
        arrayWordB.add(label);
        WordData cable = new WordData("keɪbl", "32082141", "cable", "21");
        arrayWordB.add(cable);
        WordExampleHashMap.put("21", arrayWordB);
    }

    private void setStaticDataWordLongI() {
        ArrayList<WordData> arrayWordLongi = new ArrayList<WordData>();
        WordData sheep = new WordData("ʃi:p", "360929", "sheep", "09");
        arrayWordLongi.add(sheep);
        WordData meal = new WordData("mi:l", "370941", "meal", "09");
        arrayWordLongi.add(meal);
        WordData marine = new WordData("məri:n", "3718420938", "marine", "09");
        arrayWordLongi.add(marine);
        WordData bean = new WordData("bi:n", "210938", "bean", "09");
        arrayWordLongi.add(bean);
        WordData heel = new WordData("hi:l", "400941", "heel", "09");
        arrayWordLongi.add(heel);
        WordData cheep = new WordData("tʃi:p", "310929", "cheep", "09");
        arrayWordLongi.add(cheep);
        WordData sleep = new WordData("sli:p", "35410929", "sleep", "09");
        arrayWordLongi.add(sleep);
        WordData cheek = new WordData("tʃi:k", "310932", "cheek", "09");
        arrayWordLongi.add(cheek);
        WordData cheese = new WordData("tʃi:z", "310927", "cheese", "09");
        arrayWordLongi.add(cheese);
        WordData three = new WordData("θri:", "344209", "three", "09");
        arrayWordLongi.add(three);
        WordData squeeze = new WordData("skwi:z", "3532430927", "squeeze", "09");
        arrayWordLongi.add(squeeze);
        WordExampleHashMap.put("09", arrayWordLongi);


    }

    private void setStaticDataWordLongU() {
        ArrayList<WordData> arrayWordLongU = new ArrayList<WordData>();
        WordData shoe = new WordData("ʃu:", "3610", "shoe", "10");
        arrayWordLongU.add(shoe);
        WordData blue = new WordData("blu:", "214110", "blue", "10");
        arrayWordLongU.add(blue);
        WordData foolish = new WordData("fu:lɪʃ", "3310411436", "foolish", "10");
        arrayWordLongU.add(foolish);
        WordData pool = new WordData("pu:l", "291041", "pool", "10");
        arrayWordLongU.add(pool);
        WordData food = new WordData("fu:d", "331022", "food", "10");
        arrayWordLongU.add(food);
        WordData glue = new WordData("glu:", "244110", "glue", "10");
        arrayWordLongU.add(glue);
        WordData choose = new WordData("tʃu:z", "311027", "choose", "10");
        arrayWordLongU.add(choose);
        WordData boot = new WordData("bu:t", "211030", "boot", "10");
        arrayWordLongU.add(boot);
        WordData whose = new WordData("hu:z", "401027", "whose", "10");
        arrayWordLongU.add(whose);
        WordData clue = new WordData("klu:", "324110", "clue", "10");
        arrayWordLongU.add(clue);
        WordExampleHashMap.put("10", arrayWordLongU);


    }

    private void setStaticDataWordLongA() {
        ArrayList<WordData> arrayWordLongA = new ArrayList<WordData>();
        WordData guard = new WordData("gɑːd", "241122", "guard", "11");
        arrayWordLongA.add(guard);
        WordData heart = new WordData("hɑːt", "401130", "heart", "11");
        arrayWordLongA.add(heart);
        WordData father = new WordData("fɑːðə", "33112618", "father", "11");
        arrayWordLongA.add(father);
        WordData start = new WordData("stɑːt", "35301130", "start", "11");
        arrayWordLongA.add(start);
        WordData hard = new WordData("hɑːd", "401122", "hard", "11");
        arrayWordLongA.add(hard);
        WordData cart = new WordData("kɑːt", "321130", "cart", "11");
        arrayWordLongA.add(cart);
        WordData march = new WordData("mɑːtʃ", "371131", "march", "11");
        arrayWordLongA.add(march);
        WordData marvelous = new WordData("mɑːvələs", "37112518411835", "marvelous", "11");
        arrayWordLongA.add(marvelous);
        WordData smart = new WordData("smɑːt", "35371130", "smart", "11");
        arrayWordLongA.add(smart);
        WordData laugh = new WordData("lɑːf", "411133", "laugh", "11");
        arrayWordLongA.add(laugh);
        WordExampleHashMap.put("11", arrayWordLongA);
    }

    private void setStaticDataWordLongO() {
        ArrayList<WordData> arrayWordLongO = new ArrayList<WordData>();
        WordData horse = new WordData("hɔːs", "401235", "horse", "12");
        arrayWordLongO.add(horse);
        WordData ball = new WordData("bɔːl", "211241", "ball", "12");
        arrayWordLongO.add(ball);
        WordData four = new WordData("fɔː", "3312", "four", "12");
        arrayWordLongO.add(four);
        WordData floor = new WordData("flɔː", "334112", "floor", "12");
        arrayWordLongO.add(floor);
        WordData sport = new WordData("spɔːt", "35291230", "sport", "12");
        arrayWordLongO.add(sport);
        WordData chore = new WordData("tʃɔː", "3112", "chore", "12");
        arrayWordLongO.add(chore);
        WordData awful = new WordData("ɔːfʊl", "12331541", "awful", "12");
        arrayWordLongO.add(awful);
        WordData court = new WordData("kɔːt", "321230", "court", "12");
        arrayWordLongO.add(court);
        WordData pause = new WordData("pɔːz", "291227", "pause", "12");
        arrayWordLongO.add(pause);
        WordData boring = new WordData("bɔːrɪŋ", "21121439", "boring", "12");
        arrayWordLongO.add(boring);
        WordData draw = new WordData("drɔː", "224212", "draw", "12");
        arrayWordLongO.add(draw);
        WordExampleHashMap.put("12", arrayWordLongO);
    }

    private void setStaticDataWordLongE() {
        ArrayList<WordData> arrayWordLongE = new ArrayList<WordData>();
        WordData bird = new WordData("bɜ:d", "211322", "bird", "13");
        arrayWordLongE.add(bird);
        WordData burst = new WordData("bɜ:st", "21133530", "burst", "13");
        arrayWordLongE.add(burst);
        WordData world = new WordData("wɜ:ld", "43134122", "world", "13");
        arrayWordLongE.add(world);
        WordData girl = new WordData("gɜ:l", "241341", "girl", "13");
        arrayWordLongE.add(girl);
        WordData early = new WordData("ɜ:rlɪ", "13424114", "early", "13");
        arrayWordLongE.add(early);
        WordData search = new WordData("sɜ:tʃ", "351331", "search", "13");
        arrayWordLongE.add(search);
        WordData occur = new WordData("əkɜ:r", "18321342", "occur", "13");
        arrayWordLongE.add(occur);
        WordData circuit = new WordData("sɜ:kɪt", "3513321430", "circuit", "13");
        arrayWordLongE.add(circuit);
        WordData prefer = new WordData("prɪfɜ:r", "294214331342", "prefer", "13");
        arrayWordLongE.add(prefer);
        WordExampleHashMap.put("13", arrayWordLongE);
    }

    private void setStaticDataWordShortI() {
        ArrayList<WordData> arrayWordShortI = new ArrayList<WordData>();
        WordData grin = new WordData("grɪn", "24421438", "grin", "14");
        arrayWordShortI.add(grin);
        WordData miss = new WordData("mɪs", "371435", "miss", "14");
        arrayWordShortI.add(miss);
        WordData click = new WordData("klɪk", "32411432", "click", "14");
        arrayWordShortI.add(click);
        WordData fixed = new WordData("fɪkst", "3314323530", "fixed", "14");
        arrayWordShortI.add(fixed);
        WordData sixteen = new WordData("sɪksti:n", "35143235300938", "sixteen", "14");
        arrayWordShortI.add(sixteen);
        WordData quick = new WordData("kwɪk", "32431432", "quick", "14");
        arrayWordShortI.add(quick);
        WordData tick = new WordData("tɪk", "301432", "tick", "14");
        arrayWordShortI.add(tick);
        WordData fantastic = new WordData("fæntæstɪk", "332038302035301432", "fantastic", "14");
        arrayWordShortI.add(fantastic);
        WordData minute = new WordData("mɪnɪt", "3714381430", "minute", "14");
        arrayWordShortI.add(minute);
        WordData decide = new WordData("dɪsaɪd", "2214350322", "decide", "14");
        arrayWordShortI.add(decide);
        WordExampleHashMap.put("14", arrayWordShortI);
    }

    private void setStaticDataWordShortU() {
        ArrayList<WordData> arrayWordShortU = new ArrayList<WordData>();
        WordData cook = new WordData("kʊk", "321532", "cook", "15");
        arrayWordShortU.add(cook);
        WordData good = new WordData("gʊd", "241522", "good", "15");
        arrayWordShortU.add(good);
        WordData would = new WordData("wʊd", "431522", "would", "15");
        arrayWordShortU.add(would);
        WordData wolf = new WordData("wʊlf", "43154133", "wolf", "15");
        arrayWordShortU.add(wolf);
        WordData pull = new WordData("pʊl", "291541", "pull", "15");
        arrayWordShortU.add(pull);
        WordData footer = new WordData("fʊtə", "33153018", "footer", "15");
        arrayWordShortU.add(footer);
        WordData should = new WordData("ʃʊd", "361522", "should", "15");
        arrayWordShortU.add(should);
        WordData book = new WordData("bʊk", "211532", "book", "15");
        arrayWordShortU.add(book);
        WordData woman = new WordData("wʊmən", "4315371838", "woman", "15");
        arrayWordShortU.add(woman);
        WordExampleHashMap.put("15", arrayWordShortU);
    }

    private void setStaticDataWordShortA() {
        ArrayList<WordData> arrayWordShortA = new ArrayList<WordData>();
        WordData club = new WordData("klʌb", "32411621", "club", "16");
        arrayWordShortA.add(club);
        WordData bunch = new WordData("bʌntʃ", "21163831", "bunch", "16");
        arrayWordShortA.add(bunch);
        WordData funny = new WordData("fʌnɪ", "33163814", "funny", "16");
        arrayWordShortA.add(funny);
        WordData hunt = new WordData("hʌnt", "40163830", "hunt", "16");
        arrayWordShortA.add(hunt);
        WordData dump = new WordData("dʌmp", "22163729", "dump", "16");
        arrayWordShortA.add(dump);
        WordData some = new WordData("sʌm", "351637", "some", "16");
        arrayWordShortA.add(some);
        WordData coming = new WordData("kʌmɪŋ", "3216371439", "coming", "16");
        arrayWordShortA.add(coming);
        WordData thumb = new WordData("θʌm", "341637", "thumb", "16");
        arrayWordShortA.add(thumb);
        WordData number = new WordData("nʌmbə", "3816372118", "number", "16");
        arrayWordShortA.add(number);
        WordData wonderful = new WordData("wʌndəfʊl", "4316382218331541", "wondeful", "16");
        arrayWordShortA.add(wonderful);
        WordExampleHashMap.put("16", arrayWordShortA);
    }

    private void setStaticDataWordShortO() {
        ArrayList<WordData> arrayWordShortO = new ArrayList<WordData>();
        WordData shot = new WordData("ʃɒt", "361730", "shot", "17");
        arrayWordShortO.add(shot);
        WordData clock = new WordData("klɒk", "32411732", "clock", "17");
        arrayWordShortO.add(clock);
        WordData fox = new WordData("fɒks", "33173235", "fox", "17");
        arrayWordShortO.add(fox);
        WordData boss = new WordData("bɒs", "211735", "boss", "17");
        arrayWordShortO.add(boss);
        WordData cost = new WordData("kɒst", "32173530", "cost", "17");
        arrayWordShortO.add(cost);
        WordData chop = new WordData("tʃɒp", "311729", "chop", "17");
        arrayWordShortO.add(chop);
        WordData follow = new WordData("fɒləʊ", "33174105", "follow", "17");
        arrayWordShortO.add(follow);
        WordData knock = new WordData("nɒk", "381732", "knock", "17");
        arrayWordShortO.add(knock);
        WordData lobby = new WordData("lɒbɪ", "41172114", "lobby", "17");
        arrayWordShortO.add(lobby);
        WordData adopt = new WordData("ədɒpt", "1822172930", "adopt", "17");
        arrayWordShortO.add(adopt);
        WordExampleHashMap.put("17", arrayWordShortO);
    }

    private void setStaticDataWordShortOW() {
        ArrayList<WordData> arrayWordShortOW = new ArrayList<WordData>();
        WordData banana = new WordData("bənɑːnə", "211838113818", "banana", "18");
        arrayWordShortOW.add(banana);
        WordData letter = new WordData("letə", "41193018", "letter", "18");
        arrayWordShortOW.add(letter);
        WordData calendar = new WordData("kælɪndə", "32204114382218", "calendar", "18");
        arrayWordShortOW.add(calendar);
        WordData picture = new WordData("pɪktʃə", "2914323118", "picture", "18");
        arrayWordShortOW.add(picture);
        WordData color = new WordData("kʌlə", "32164118", "color", "18");
        arrayWordShortOW.add(color);
        WordData figure = new WordData("fɪgə", "33142418", "figure", "18");
        arrayWordShortOW.add(figure);
        WordData accept = new WordData("əksept", "183235192930", "accept", "18");
        arrayWordShortOW.add(accept);
        WordData occur = new WordData("əkɜ:r", "18321342", "occur", "18");
        arrayWordShortOW.add(occur);
        WordData percent = new WordData("pəsent", "291835193830", "percent", "18");
        arrayWordShortOW.add(percent);
        WordData around = new WordData("əraʊnd", "1842073822", "around", "18");
        arrayWordShortOW.add(around);
        WordData surprise = new WordData("səpraɪz", "351829420327", "surprize", "18");
        arrayWordShortOW.add(surprise);
        WordExampleHashMap.put("18", arrayWordShortOW);
    }

    private void setStaticDataWordShortE() {
        ArrayList<WordData> arrayWordShortE = new ArrayList<WordData>();
        WordData bench = new WordData("bentʃ", "211931", "bench", "19");
        arrayWordShortE.add(bench);
        WordData tennis = new WordData("tenɪs", "3019381435", "tennis", "19");
        arrayWordShortE.add(tennis);
        WordData desk = new WordData("desk", "22193532", "desk", "19");
        arrayWordShortE.add(desk);
        WordData better = new WordData("betə", "21193018", "better", "19");
        arrayWordShortE.add(better);
        WordData when = new WordData("wen", "431938", "when", "19");
        arrayWordShortE.add(when);
        WordData best = new WordData("best", "21193530", "best", "19");
        arrayWordShortE.add(best);
        WordData setup = new WordData("setʌp", "3519301629", "setup", "19");
        arrayWordShortE.add(setup);
        WordData west = new WordData("west", "43193530", "west", "19");
        arrayWordShortE.add(west);
        WordData desert = new WordData("dezət", "2219271830", "desert", "19");
        arrayWordShortE.add(desert);
        WordData head = new WordData("hed", "401922", "head", "19");
        arrayWordShortE.add(head);
        WordData pedal = new WordData("pedl", "29192241", "pedal", "19");
        arrayWordShortE.add(pedal);
        WordExampleHashMap.put("19", arrayWordShortE);


    }

    private void setStaticDataWordShortAE() {
        ArrayList<WordData> arrayWordShortAE = new ArrayList<WordData>();
        WordData cat = new WordData("kæt", "322030", "cat", "20");
        arrayWordShortAE.add(cat);
        WordData paddle = new WordData("pædl", "29202241", "paddle", "20");
        arrayWordShortAE.add(paddle);
        WordData dad = new WordData("dæd", "222022", "dad", "20");
        arrayWordShortAE.add(dad);
        WordData catchWord = new WordData("kætʃ", "322031", "cacht", "20");
        arrayWordShortAE.add(catchWord);
        WordData have = new WordData("hæv", "402025", "have", "20");
        arrayWordShortAE.add(have);
        WordData chapter = new WordData("tʃæptə", "3120293018", "chapter", "20");
        arrayWordShortAE.add(chapter);
        WordData perhaps = new WordData("pəhæps", "291840202935", "perhaps", "20");
        arrayWordShortAE.add(perhaps);
        WordData plan = new WordData("plæn", "29412038", "plan", "20");
        arrayWordShortAE.add(plan);
        WordData band = new WordData("bænd", "21203822", "band", "20");
        arrayWordShortAE.add(band);
        WordData handle = new WordData("hændl", "4020382241", "handle", "20");
        arrayWordShortAE.add(handle);
        WordData match = new WordData("mætʃ", "372031", "match", "20");
        arrayWordShortAE.add(match);
        WordExampleHashMap.put("20", arrayWordShortAE);
    }

    public void setStaticDataWordD() {

        ArrayList<WordData> arrayWordD = new ArrayList<WordData>();

        WordData ladder = new WordData("lædə", "41202218", "ladder", "22");
        arrayWordD.add(ladder);
        WordData desk = new WordData("desk", "22193532", "desk", "22");
        arrayWordD.add(desk);
        WordData duck = new WordData("dʌk", "221632", "duck", "22");
        arrayWordD.add(duck);
        WordData door = new WordData("dɔ:", "2212", "door", "22");
        arrayWordD.add(door);
        WordData ride = new WordData("raid", "420322", "ride", "22");
        arrayWordD.add(ride);
        WordData bide = new WordData("baid", "210322", "bide", "22");
        arrayWordD.add(bide);
        WordData drink = new WordData("driηk", "22423932", "drink", "22");
        arrayWordD.add(drink);
        WordData date = new WordData("deit", "220830", "date", "22");
        arrayWordD.add(date);
        WordData cord = new WordData("kɔ:d", "321222", "cord", "22");
        arrayWordD.add(cord);
        WordData guard = new WordData("gɑ:d", "241122", "guard", "22");
        arrayWordD.add(guard);
        WordExampleHashMap.put("22", arrayWordD);

    }

    public void setStaticDataWordDZ() {

        ArrayList<WordData> arrayWordDZ = new ArrayList<WordData>();

        WordData joy = new WordData("dʒɔɪ", "2304", "joy", "23");
        arrayWordDZ.add(joy);
        WordData joke = new WordData("dʒəʊk", "230532", "joke", "23");
        arrayWordDZ.add(joke);
        WordData gin = new WordData("dʒɪn", "231438", "gin", "23");
        arrayWordDZ.add(gin);
        WordData edging = new WordData("ɛdʒɪŋ", "34231439", "edging", "23");
        arrayWordDZ.add(edging);
        WordData solider = new WordData("sɒlɪd", "3517411422", "solider", "23");
        arrayWordDZ.add(solider);
        WordData judge = new WordData("dʒʌdʒ", "231623", "judge", "23");
        arrayWordDZ.add(judge);
        WordData age = new WordData("eɪdʒ", "0823", "age", "23");
        arrayWordDZ.add(age);
        WordData large = new WordData("lɑːdʒ", "411123", "large", "23");
        arrayWordDZ.add(large);
        WordData jeep = new WordData("dʒiːp", "230929", "jeep", "23");
        arrayWordDZ.add(jeep);
        WordData june = new WordData("dʒuːn", "231038", "june", "23");
        arrayWordDZ.add(june);
        WordData lunge = new WordData("lʌndʒ", "41163823", "lunge", "23");
        arrayWordDZ.add(lunge);
        WordData dangerous = new WordData("deɪndʒərəs", "2208382318421835", "dangerous", "23");
        arrayWordDZ.add(dangerous);
        WordData hedge = new WordData("hɛdʒ", "323423", "hedge", "23");
        arrayWordDZ.add(hedge);
        WordExampleHashMap.put("23", arrayWordDZ);
    }

    public void setStaticDataWordG() {
        ArrayList<WordData> arrayWordG = new ArrayList<WordData>();

        WordData ghost = new WordData("ɡəʊst", "24053530", "ghost", "24");
        arrayWordG.add(ghost);
        WordData giggle = new WordData("ɡɪɡəl", "2414241841", "giggle", "24");
        arrayWordG.add(giggle);
        WordData gentle = new WordData("dʒɛntl", "2334383041", "gentle", "24");
        arrayWordG.add(gentle);
        WordData gold = new WordData("ɡəʊld", "24054122", "gold", "24");
        arrayWordG.add(gold);
        WordData good = new WordData("ɡʊd", "241522", "good", "24");
        arrayWordG.add(good);
        WordData goat = new WordData("ɡəʊt", "240530", "goat", "24");
        arrayWordG.add(goat);
        WordData bag = new WordData("bæg", "212024", "bag", "24");
        arrayWordG.add(bag);
        WordData frog = new WordData("frɔg", "33421224", "frog", "24");
        arrayWordG.add(frog);
        WordData again = new WordData("əgen", "18241938", "again", "24");
        arrayWordG.add(again);
        WordData together = new WordData("təgeðə", "301824192618", "together", "24");
        arrayWordG.add(together);
        WordData gather = new WordData("'gæðə", "24202618", "gather", "24");
        arrayWordG.add(gather);
        WordExampleHashMap.put("24", arrayWordG);


    }

    public void setStaticDataWordV() {
        ArrayList<WordData> arrayWord25 = new ArrayList<WordData>();

        WordData favourite = new WordData("'feɪvərɪt", "33082518421430", "favourite", "25");
        arrayWord25.add(favourite);
        WordData oven = new WordData("'ʌvn", "162538", "oven", "25");
        arrayWord25.add(oven);
        WordData view = new WordData("vju:", "254410", "view", "25");
        arrayWord25.add(view);
        WordData heavy = new WordData("hevɪ", "40192514", "heavy", "25");
        arrayWord25.add(heavy);
        WordData move = new WordData("mu:v", "371025", "move", "25");
        arrayWord25.add(move);
        WordData veal = new WordData("vi:l", "240941", "veal", "25");
        arrayWord25.add(veal);
        WordData vine = new WordData("vain", "240338", "vine", "25");
        arrayWord25.add(vine);
        WordData veil = new WordData("veil", "240841", "viel", "25");
        arrayWord25.add(veil);
        WordData leave = new WordData("li:v", "410925", "leave", "25");
        arrayWord25.add(leave);
        WordData vest = new WordData("vest", "25193530", "vest", "25");
        arrayWord25.add(vest);
        WordData halve = new WordData("hɑ:v", "401125", "halve", "25");
        arrayWord25.add(halve);
        WordData vote = new WordData("vəʊt", "250530", "vote", "25");
        arrayWord25.add(vote);
        WordData valley = new WordData("vælɪ", "25204114", "valley", "25");
        arrayWord25.add(valley);
        WordExampleHashMap.put("25", arrayWord25);

    }

    public void setStaticDataWordStrongTH() {
        ArrayList<WordData> arrayWord26 = new ArrayList<WordData>();

        WordData they = new WordData("ðei", "2608", "they", "26");
        arrayWord26.add(they);
        WordData father = new WordData("fɑ:ðə", "33112618", "father", "26");
        arrayWord26.add(father);
        WordData thisword = new WordData("'ðɪs", "261435", "this", "26");
        arrayWord26.add(thisword);
        WordData other = new WordData("ʌðər", "16261842", "other", "26");
        arrayWord26.add(other);
        WordData smooth = new WordData("smu:ð", "35371026", "smooth", "26");
        arrayWord26.add(smooth);
        WordData feather = new WordData("feðə", "33192618", "feather", "26");
        arrayWord26.add(feather);
        WordData than = new WordData("ðæn", "262038", "than", "26");
        arrayWord26.add(than);
        WordData there = new WordData("ðeə", "2606", "there", "26");
        arrayWord26.add(there);
        WordData those = new WordData("ðouz", "261727", "those", "26");
        arrayWord26.add(those);
        WordData either = new WordData("aɪðər", "03261842", "either", "26");
        arrayWord26.add(either);
        WordData bathe = new WordData("beɪð", "210826", "bathe", "26");
        arrayWord26.add(bathe);
        WordData clothe = new WordData("kləʊð", "32410526", "clothe", "26");
        arrayWord26.add(clothe);
        WordData breathe = new WordData("bri:ð", "21420926", "breathe", "26");
        arrayWord26.add(breathe);
        WordExampleHashMap.put("26", arrayWord26);

    }

    public void setStaticDataWordZ() {
        ArrayList<WordData> arrayWord27 = new ArrayList<WordData>();

        WordData rise = new WordData("raiz", "420327", "rise", "27");
        arrayWord27.add(rise);
        WordData zero = new WordData("ziərəʊ", "27014205", "zero", "27");  // fix
        arrayWord27.add(zero);
        WordData music = new WordData("mju:zik", "374410271432", "music", "27");
        arrayWord27.add(music);
        WordData buzz = new WordData("bʌz", "211627", "buzz", "27");
        arrayWord27.add(buzz);
        WordData zoo = new WordData("zu:", "2710", "zoo", "27");
        arrayWord27.add(zoo);
        WordData zip = new WordData("zɪp", "271429", "zip", "27");
        arrayWord27.add(zip);
        WordData prize = new WordData("praiz", "29420327", "prize", "27");
        arrayWord27.add(prize);
        WordData surprissing = new WordData("səpraiziη", "3518294203271439", "surprissing", "27");
        arrayWord27.add(surprissing);
        WordData noise = new WordData("nɔiz", "380427", "noise", "27");
        arrayWord27.add(noise);
        WordData amaze = new WordData("əmeiz", "18370827", "amaze", "27");
        arrayWord27.add(amaze);
        WordExampleHashMap.put("27", arrayWord27);


    }

    public void setStaticDataWordZO() {
        ArrayList<WordData> arrayWord28 = new ArrayList<WordData>();

        WordData leisure = new WordData("leʒə", "41192818", "leisure", "28");
        arrayWord28.add(leisure);
        WordData television = new WordData("teliviʒn", "3019411425142838", "television", "28");
        arrayWord28.add(television);
        WordData pleasure = new WordData("pleʒə", "2941192818", "pleasure", "28");
        arrayWord28.add(pleasure);
        WordData vision = new WordData("viʒn", "25142838", "vision", "28");
        arrayWord28.add(vision);
        WordData garage = new WordData("gærɑ:ʒ", "2406421128", "garage", "28");
        arrayWord28.add(garage);
        WordData measure = new WordData("meʒə", "37192818", "measure", "28");
        arrayWord28.add(measure);
        WordData treasure = new WordData("treʒə", "3042192818", "treasure", "28");
        arrayWord28.add(treasure);
        WordData casual = new WordData("kæʒjuəl", "322028440241", "casual", "28");
        arrayWord28.add(casual);
        WordData unusual = new WordData("ʌnju:ʒl", "163844102841", "unusual", "28");
        arrayWord28.add(unusual);
        WordData collision = new WordData("kəliʒn", "321841142838", "collision", "28");
        arrayWord28.add(collision);
        WordData barrage = new WordData("bærɑ:ʒ", "2120421128", "barrage", "28");
        arrayWord28.add(barrage);
        WordData massage = new WordData("mæsɑ:ʒ", "3720351128", "massage", "28");
        arrayWord28.add(massage);
        WordExampleHashMap.put("28", arrayWord28);

    }

    public void setStaticDataWordP() {
        ArrayList<WordData> arrayWord29 = new ArrayList<WordData>();

        WordData part = new WordData("pɑ:t", "291130", "part", "29");
        arrayWord29.add(part);
        WordData pink = new WordData("piηk", "29143932", "pink", "29");
        arrayWord29.add(pink);
        WordData happiness = new WordData("hæpinis", "40202914381435", "happiness", "29");
        arrayWord29.add(happiness);
        WordData peach = new WordData("pi:t∫", "29093036", "peach", "29");
        arrayWord29.add(peach);
        WordData push = new WordData("pu∫", "291536", "push", "29");
        arrayWord29.add(push);
        WordData pig = new WordData("pig", "291424", "pig", "29");
        arrayWord29.add(pig);
        WordData penal = new WordData("pi:nl", "29093841", "penal", "29");
        arrayWord29.add(penal);
        WordData pocket = new WordData("pɒkɪt", "2917321430", "pocket", "29");
        arrayWord29.add(pocket);
        WordData postcard = new WordData("pəʊstkɑːd", "29053530321122", "postcard", "29");
        arrayWord29.add(postcard);
        WordExampleHashMap.put("29", arrayWord29);


    }

    public void setStaticDataWordT() {
        ArrayList<WordData> arrayWord30 = new ArrayList<WordData>();

        WordData tell = new WordData("tel", "301941", "tell", "30");
        arrayWord30.add(tell);
        WordData tall = new WordData("tɔːl", "301241", "tall", "30");
        arrayWord30.add(tall);
        WordData steak = new WordData("steik", "35300832", "steak", "30");
        arrayWord30.add(steak);
        WordData tomato = new WordData("təmɑːtəʊ", "301837113005", "tomato", "30");
        arrayWord30.add(tomato);
        WordData tennis = new WordData("tenɪs", "3019381435", "tennis", "30");
        arrayWord30.add(tennis);
        WordData teach = new WordData("tiːtʃ", "30103036", "teach", "30");
        arrayWord30.add(teach);
        WordData twist = new WordData("twɪst", "3043143530", "twist", "30");
        arrayWord30.add(twist);
        WordData telephone = new WordData("telɪfəʊn", "30193814330538", "telephone", "30");
        arrayWord30.add(telephone);
        WordData pretty = new WordData("priti", "2942143014", "pretty", "30");
        arrayWord30.add(pretty);
        WordData student = new WordData("stju:dnt", "35304410223830", "student", "30");
        arrayWord30.add(student);
        WordData tight = new WordData("tait", "300330", "tight", "30");
        arrayWord30.add(tight);
        WordExampleHashMap.put("30", arrayWord30);


    }

    public void setStaticDataWordCH() {
        ArrayList<WordData> arrayWord31 = new ArrayList<WordData>();

        WordData chain = new WordData("tʃeɪn", "30360838", "chain", "31");
        arrayWord31.add(chain);
        WordData chick = new WordData("tʃɪk", "30361432", "chick", "31");
        arrayWord31.add(chick);
        WordData nature = new WordData("neɪtʃə", "3808303618", "nature", "31");
        arrayWord31.add(nature);
        WordData question = new WordData("kwestʃən", "3243193530361838", "question", "31");
        arrayWord31.add(question);
        WordData church = new WordData("tʃɜːtʃ", "311331", "church", "31");
        arrayWord31.add(church);
        WordData match = new WordData("mætʃ", "372031", "match", "31");
        arrayWord31.add(match);
        WordData cherry = new WordData("tʃeri", "31194214", "cherry", "31");
        arrayWord31.add(cherry);
        WordData chips = new WordData("tʃɪps", "31142935", "chips", "31");
        arrayWord31.add(chips);
        WordData cheap = new WordData("tʃiːp", "310929", "cheap", "31");
        arrayWord31.add(cheap);
        WordData chop = new WordData("tʃɒp", "311729", "chop", "31");
        arrayWord31.add(chop);
        WordData catchword = new WordData("kætʃ", "322036", "catch", "31");
        arrayWord31.add(catchword);
        WordData watch = new WordData("wɒtʃ", "431731", "watch", "31");
        arrayWord31.add(watch);
        WordExampleHashMap.put("31", arrayWord31);

    }

    public void setStaticDataWordK() {
        ArrayList<WordData> arrayWord32 = new ArrayList<WordData>();

        WordData check = new WordData("tʃek", "311932", "check", "32");
        arrayWord32.add(check);
        WordData key = new WordData("kiː", "3209", "key", "32");
        arrayWord32.add(key);
        WordData clock = new WordData("klɒk", "32411732", "clock", "32");
        arrayWord32.add(clock);
        WordData school = new WordData("skuːl", "35321041", "school", "32");
        arrayWord32.add(school);
        WordData cold = new WordData("kəʊld", "32054122", "cold", "32");
        arrayWord32.add(cold);
        WordData coat = new WordData("kəʊt", "320530", "coat", "32");
        arrayWord32.add(coat);
        WordData cup = new WordData("kʌp", "321629", "cup", "32");
        arrayWord32.add(cup);
        WordData coffee = new WordData("kɒfi", "32173314", "coffee", "32");
        arrayWord32.add(coffee);
        WordData pocket = new WordData("pɒkɪt", "2917321430", "pocket", "32");
        arrayWord32.add(pocket);
        WordData scarf = new WordData("skɑːf", "35321133", "scarf", "32");
        arrayWord32.add(scarf);
        WordData scooter = new WordData("skuːtə", "3532103018", "scooter", "32");
        arrayWord32.add(scooter);
        WordData because = new WordData("bɪkəz", "2114321827", "because", "32");
        arrayWord32.add(because);
        WordData carpet = new WordData("kɑːpɪt", "3211291430", "carpet", "32");
        arrayWord32.add(carpet);
        WordExampleHashMap.put("32", arrayWord32);

    }

    public void setStaticDataWordF() {
        ArrayList<WordData> arrayWord33 = new ArrayList<WordData>();

        WordData fan = new WordData("fæn", "332038", "fan", "33");
        arrayWord33.add(fan);
        WordData phone = new WordData("fəʊn", "330538", "phone", "33");
        arrayWord33.add(phone);
        WordData laugh = new WordData("lɑːf", "411133", "laugh", "33");
        arrayWord33.add(laugh);
        WordData coffee = new WordData("kɒfi", "32173314", "coffee", "33");
        arrayWord33.add(coffee);
        WordData photo = new WordData("fəʊtəʊ", "33053005", "photo", "33");
        arrayWord33.add(photo);
        WordData atmosphere = new WordData("ætməsfɪə", "2030371835331418", "atmosphere", "33");
        arrayWord33.add(atmosphere);
        WordData feel = new WordData("fiːl", "330941", "feel", "33");
        arrayWord33.add(feel);
        WordData failure = new WordData("feɪljə", "3308414418", "failure", "33");
        arrayWord33.add(failure);
        WordData fine = new WordData("faɪn", "330338", "fine", "33");
        arrayWord33.add(fine);
        WordData feet = new WordData("fiːt", "330930", "feet", "33");
        arrayWord33.add(feet);
        WordExampleHashMap.put("33", arrayWord33);


    }

    public void setStaticDataWordTH() {
        ArrayList<WordData> arrayWord34 = new ArrayList<WordData>();

        WordData thief = new WordData("θiːf", "340933", "thief", "34");
        arrayWord34.add(thief);
        WordData thin = new WordData("θɪn", "341438", "thin", "34");
        arrayWord34.add(thin);
        WordData teeth = new WordData("tiːθ", "300934", "teeth", "34");
        arrayWord34.add(teeth);
        WordData thing = new WordData("θɪŋ", "341439", "thing", "34");
        arrayWord34.add(thing);
        WordData anther = new WordData("ˈænθə", "20383418", "anther", "34");
        arrayWord34.add(anther);
        WordData path = new WordData("pɑːθ", "291134", "path", "34");
        arrayWord34.add(path);
        WordData worth = new WordData("wɜːθ", "431334", "worth", "34");
        arrayWord34.add(worth);
        WordData thick = new WordData("θɪk", "341432", "thick", "34");
        arrayWord34.add(thick);
        WordData wrath = new WordData("rɒθ", "421734", "wrath", "34");
        arrayWord34.add(wrath);
        WordData mouth = new WordData("maʊθ", "370734", "mouth", "34");
        arrayWord34.add(mouth);
        WordData think = new WordData("θɪŋk", "34143932", "think", "34");
        arrayWord34.add(think);
        WordData three = new WordData("θriː", "344209", "three", "34");
        arrayWord34.add(three);
        WordData thirsty = new WordData("θɜːsti", "3413353014", "thirsty", "34");
        arrayWord34.add(thirsty);
        WordExampleHashMap.put("34", arrayWord34);

    }

    public void setStaticDataWordS() {
        ArrayList<WordData> arrayWord35 = new ArrayList<WordData>();

        WordData soon = new WordData("suːn", "351038", "soon", "35");
        arrayWord35.add(soon);
        WordData sick = new WordData("sɪk", "351432", "sick", "35");
        arrayWord35.add(sick);
        WordData sister = new WordData("sɪstə", "3514353018", "sister", "35");
        arrayWord35.add(sister);
        WordData price = new WordData("praɪs", "29420335", "price", "35");
        arrayWord35.add(price);
        WordData piece = new WordData("piːs", "290935", "piece", "35");
        arrayWord35.add(piece);
        WordData bus = new WordData("bʌs", "211635", "bus", "35");
        arrayWord35.add(bus);
        WordData star = new WordData("stɑː", "353011", "star", "35");
        arrayWord35.add(star);
        WordData swim = new WordData("swɪm", "35431437", "swim", "35");
        arrayWord35.add(swim);
        WordData sleep = new WordData("sliːp", "35410929", "sleep", "35");
        arrayWord35.add(sleep);
        WordData excited = new WordData("ɪksaɪtɪd", "14323503301422", "excited", "35");
        arrayWord35.add(excited);
        WordExampleHashMap.put("35", arrayWord35);


    }

    public void setStaticDataWordSH() {
        ArrayList<WordData> arrayWord36 = new ArrayList<WordData>();

        WordData shop = new WordData("ʃɒp", "361729", "shop", "36");
        arrayWord36.add(shop);
        WordData sure = new WordData("ʃɔː", "3612", "sure", "36");
        arrayWord36.add(sure);
        WordData chef = new WordData("ʃef", "361933", "chef", "36");
        arrayWord36.add(chef);
        WordData ship = new WordData("ʃɪp", "361429", "ship", "36");
        arrayWord36.add(ship);
        WordData national = new WordData("næʃnl", "3820363841", "national", "36");
        arrayWord36.add(national);
        WordData fish = new WordData("fɪʃ", "331436", "fish", "36");
        arrayWord36.add(fish);
        WordData mosh = new WordData("mɒʃ", "371736", "mosh", "36");
        arrayWord36.add(mosh);
        WordData wash = new WordData("wɒʃ", "431736", "wash", "36");
        arrayWord36.add(wash);
        WordData push = new WordData("pʊʃ", "291536", "push", "36");
        arrayWord36.add(push);
        WordData shack = new WordData("ʃæk", "362032", "shack", "36");
        arrayWord36.add(shack);
        WordData shock = new WordData("ʃɒk", "361732", "shock", "36");
        arrayWord36.add(shock);
        WordData should = new WordData("ʃʊd", "361522", "should", "36");
        arrayWord36.add(should);
        WordExampleHashMap.put("36", arrayWord36);

    }

    public void setStaticDataWordM() {
        ArrayList<WordData> arrayWord37 = new ArrayList<WordData>();

        WordData summer = new WordData("sʌmə", "35163718", "summer", "37");
        arrayWord37.add(summer);
        WordData hammer = new WordData("hæmə", "40203718", "hammer", "37");
        arrayWord37.add(hammer);
        WordData bump = new WordData("bʌmp", "21163729", "bump", "37");
        arrayWord37.add(bump);
        WordData camp = new WordData("kæmp", "32203729", "camp", "37");
        arrayWord37.add(camp);
        WordData lymph = new WordData("lɪmf", "41143733", "lymph", "37");
        arrayWord37.add(lymph);
        WordData empty = new WordData("empti", "1937293014", "empty", "37");
        arrayWord37.add(empty);
        WordData temperature = new WordData("temprətʃə", "3019372942183118", "temperature", "37");
        arrayWord37.add(temperature);
        WordData time = new WordData("taɪm", "300837", "time", "37");
        arrayWord37.add(time);
        WordData tomorrow = new WordData("təmɒrəʊ", "301837174205", "tomorrow", "37");
        arrayWord37.add(tomorrow);
        WordData homeless = new WordData("həʊmləs", "400537411835", "homeless", "37");
        arrayWord37.add(homeless);
        WordData meaningful = new WordData("miːnɪŋfl", "37093814393341", "meaningful", "37");
        arrayWord37.add(meaningful);
        WordExampleHashMap.put("37", arrayWord37);


    }

    public void setStaticDataWordN() {
        ArrayList<WordData> arrayWord38 = new ArrayList<WordData>();

        WordData nice = new WordData("naɪs", "380335", "nice", "38");
        arrayWord38.add(nice);
        WordData knowledge = new WordData("nɒlɪdʒ", "3817411423", "knowledge", "38");
        arrayWord38.add(knowledge);
        WordData funny = new WordData("fʌni", "33163814", "funny", "38");
        arrayWord38.add(funny);
        WordData sunless = new WordData("sʌnləs", "351638411835", "sunless", "38");
        arrayWord38.add(sunless);
        WordData tenth = new WordData("tenθ", "30193834", "tenth", "38");
        arrayWord38.add(tenth);
        WordData bench = new WordData("bentʃ", "21193831", "bench", "38");
        arrayWord38.add(bench);
        WordData behind = new WordData("bɪhaɪnd", "211440033822", "behind", "38");
        arrayWord38.add(behind);
        WordData expensive = new WordData("ɪkspensɪv", "143235291938351425", "expensive", "38");
        arrayWord38.add(expensive);
        WordData expandable = new WordData("ɪkspændəbl", "14323529203822182141", "expandable", "38");
        arrayWord38.add(expandable);
        WordData banana = new WordData("bənɑːnə", "211838113818", "banana", "38");
        arrayWord38.add(banana);
        WordData swan = new WordData("swɒn", "35431738", "swan", "38");
        arrayWord38.add(swan);
        WordExampleHashMap.put("38", arrayWord38);


    }

    public void setStaticDataWordNG() {
        ArrayList<WordData> arrayWord39 = new ArrayList<WordData>();

        WordData sing = new WordData("sɪŋ", "351439", "sing", "39");
        arrayWord39.add(sing);
        WordData monkey = new WordData("mʌŋki", "3716393214", "monkey", "39");
        arrayWord39.add(monkey);
        WordData ring = new WordData("rɪŋ", "421439", "ring", "39");
        arrayWord39.add(ring);
        WordData anger = new WordData("æŋɡə", "20392418", "anger", "39");
        arrayWord39.add(anger);
        WordData thank = new WordData("θæŋk", "34203932", "thank", "39");
        arrayWord39.add(thank);
        WordData length = new WordData("leŋθ", "41193934", "length", "39");
        arrayWord39.add(length);
        WordData thing = new WordData("θɪŋ", "341439", "thing", "39");
        arrayWord39.add(thing);
        WordData wring = new WordData("rɪŋ", "421439", "wring", "39");
        arrayWord39.add(wring);
        WordData think = new WordData("θɪŋk", "34143932", "think", "39");
        arrayWord39.add(think);
        WordData hung = new WordData("hʌŋ", "401639", "hung", "39");
        arrayWord39.add(hung);
        WordData wing = new WordData("wɪŋ", "431439", "wing", "39");
        arrayWord39.add(wing);
        WordData pink = new WordData("pɪŋk", "29143932", "pink", "39");
        arrayWord39.add(pink);
        WordExampleHashMap.put("39", arrayWord39);

    }

    public void setStaticDataWordH() {
        ArrayList<WordData> arrayWord40 = new ArrayList<WordData>();

        WordData hello = new WordData("heləʊ", "40194105", "hello", "40");
        arrayWord40.add(hello);
        WordData house = new WordData("haʊs", "400735", "house", "40");
        arrayWord40.add(house);
        WordData whole = new WordData("həʊl", "400541", "whole", "40");
        arrayWord40.add(whole);
        WordData ahead = new WordData("əhed", "18401922", "ahead", "40");
        arrayWord40.add(ahead);
        WordData hill = new WordData("hɪl", "401441", "hill", "40");
        arrayWord40.add(hill);
        WordData heel = new WordData("hiːl", "400941", "heel", "40");
        arrayWord40.add(heel);
        WordData hound = new WordData("haʊnd", "40073822", "hound", "40");
        arrayWord40.add(hound);
        WordData hold = new WordData("həʊld", "40054122", "hold", "40");
        arrayWord40.add(hold);
        WordData hear = new WordData("hɪə", "4001", "hear", "40");
        arrayWord40.add(hear);
        WordData high = new WordData("haɪ", "4003", "high", "40");
        arrayWord40.add(high);
        WordData husband = new WordData("hʌzbənd", "40162721183822", "husband", "40");
        arrayWord40.add(husband);
        WordData happen = new WordData("hæpn", "40202938", "happen", "40");
        arrayWord40.add(happen);
        WordData hospital = new WordData("hɒspɪtl", "40173529143041", "hospital", "40");
        arrayWord40.add(hospital);
        WordData horrible = new WordData("hɒrəbl", "401742182141", "horrible", "40");
        arrayWord40.add(horrible);
        WordData perhaps = new WordData("prhæps", "204240202935", "perhaps", "40");
        arrayWord40.add(perhaps);
        WordExampleHashMap.put("40", arrayWord40);


    }

    public void setStaticDataWordL() {
        ArrayList<WordData> arrayWord41 = new ArrayList<WordData>();

        WordData letter = new WordData("letə", "41193018", "letter", "41");
        arrayWord41.add(letter);
        WordData light = new WordData("laɪt", "410330", "light", "41");
        arrayWord41.add(light);
        WordData valley = new WordData("væli", "25204114", "valley", "41");
        arrayWord41.add(valley);
        WordData feel = new WordData("fiːl", "330941", "feel", "41");
        arrayWord41.add(feel);
        WordData low = new WordData("ləʊ", "4105", "low", "41");
        arrayWord41.add(low);
        WordData line = new WordData("laɪn", "410338", "line", "41");
        arrayWord41.add(line);
        WordData jelly = new WordData("dʒeli", "23194114", "jelly", "41");
        arrayWord41.add(jelly);
        WordData tell = new WordData("tel", "301941", "tell", "41");
        arrayWord41.add(tell);
        WordData life = new WordData("laɪf", "410333", "life", "41");
        arrayWord41.add(life);
        WordData love = new WordData("lʌv", "411625", "love", "41");
        arrayWord41.add(love);
        WordData lecture = new WordData("lektʃə", "4119323118", "lecture", "41");
        arrayWord41.add(lecture);
        WordData allow = new WordData("əlaʊ", "184107", "allow", "41");
        arrayWord41.add(allow);
        WordData literature = new WordData("lɪtrətʃə", "41143042183118", "literature", "41");
        arrayWord41.add(literature);
        WordExampleHashMap.put("41", arrayWord41);

    }

    public void setStaticDataWordR() {
        ArrayList<WordData> arrayWord42 = new ArrayList<WordData>();

        WordData rule = new WordData("ruːl", "421041", "rule", "42");
        arrayWord42.add(rule);
        WordData rare = new WordData("reə", "4206", "rare", "42");
        arrayWord42.add(rare);
        WordData right = new WordData("raɪt", "420330", "right", "42");
        arrayWord42.add(right);
        WordData wrong = new WordData("rɒŋ", "421739", "wrong", "42");
        arrayWord42.add(wrong);
        WordData sorry = new WordData("sɒri", "35174214", "sorry", "42");
        arrayWord42.add(sorry);
        WordData arrange = new WordData("əreɪndʒ", "184219143823", "arrange", "42");
        arrayWord42.add(arrange);
        WordData road = new WordData("rəʊd", "420522", "road", "42");
        arrayWord42.add(road);
        WordData grass = new WordData("ɡrɑːs", "24421135", "grass", "42");
        arrayWord42.add(grass);
        WordData raise = new WordData("reɪz", "420827", "raise", "42");
        arrayWord42.add(raise);
        WordData crack = new WordData("kræk", "32422032", "crack", "42");
        arrayWord42.add(crack);
        WordData rich = new WordData("rɪtʃ", "421431", "rich", "42");
        arrayWord42.add(rich);
        WordData pretty = new WordData("prɪti", "2942143014", "pretty", "42");
        arrayWord42.add(pretty);
        WordData proud = new WordData("praʊd", "29420722", "proud", "42");
        arrayWord42.add(proud);
        WordData parent = new WordData("peərnt", "2906423830", "parent", "42");
        arrayWord42.add(parent);
        WordExampleHashMap.put("42", arrayWord42);

    }

    public void setStaticDataWordW() {
        ArrayList<WordData> arrayWord43 = new ArrayList<WordData>();

        WordData win = new WordData("wɪn", "431438", "win", "43");
        arrayWord43.add(win);
        WordData wood = new WordData("wʊd", "431522", "wood", "43");
        arrayWord43.add(wood);
        WordData wet = new WordData("wet", "431930", "wet", "43");
        arrayWord43.add(wet);
        WordData whileworld = new WordData("waɪl", "430341", "while", "43");
        arrayWord43.add(whileworld);
        WordData queen = new WordData("kwiːn", "32430938", "queen", "43");
        arrayWord43.add(queen);
        WordData wheel = new WordData("wiːl", "430941", "wheel", "43");
        arrayWord43.add(wheel);
        WordData west = new WordData("west", "43193530", "west", "43");
        arrayWord43.add(west);
        WordData wine = new WordData("waɪn", "430338", "wine", "43");
        arrayWord43.add(wine);
        WordData walk = new WordData("wɔːk", "431232", "walk", "43");
        arrayWord43.add(walk);
        WordData warm = new WordData("wɔːm", "431237", "warm", "43");
        arrayWord43.add(warm);
        WordData wonderful = new WordData("wʌndəfl", "43163822183341", "wonderful", "43");
        arrayWord43.add(wonderful);
        WordData weather = new WordData("weðə", "43192618", "weather", "43");
        arrayWord43.add(weather);
        WordData quite = new WordData("kwaɪt", "32430330", "quite", "43");
        arrayWord43.add(quite);
        WordData quick = new WordData("kwɪk", "32431432", "quick", "43");
        arrayWord43.add(quick);
        WordExampleHashMap.put("43", arrayWord43);

    }

    public void setStaticDataWordJ() {
        ArrayList<WordData> arrayWord44 = new ArrayList<WordData>();

        WordData yet = new WordData("jet", "441930", "yet", "44");
        arrayWord44.add(yet);
        WordData your = new WordData("jɔː", "4412", "your", "44");
        arrayWord44.add(your);
        WordData useful = new WordData("juːsfl", "4410353341", "useful", "44");
        arrayWord44.add(useful);
        WordData beauty = new WordData("bjuːti", "2144103014", "beauty", "44");
        arrayWord44.add(beauty);
        WordData yellow = new WordData("jeləʊ", "44194105", "yellow", "44");
        arrayWord44.add(yellow);
        WordData yolk = new WordData("jəʊk", "440532", "yolk", "44");
        arrayWord44.add(yolk);
        WordData year = new WordData("jɪə", "4401", "year", "44");
        arrayWord44.add(year);
        WordData yesterday = new WordData("jestədeɪ", "44193530182208", "yesterday", "44");
        arrayWord44.add(yesterday);
        WordData student = new WordData("stjuːdnt", "35304410223830", "student", "44");
        arrayWord44.add(student);
        WordData onion = new WordData("ʌnjən", "1638441838", "onion", "44");
        arrayWord44.add(onion);
        WordData stupid = new WordData("stjuːpɪd", "35304410291422", "stupid", "44");
        arrayWord44.add(stupid);
        WordData young = new WordData("jʌŋ", "441639", "young", "44");
        arrayWord44.add(young);
        WordExampleHashMap.put("44", arrayWord44);

    }

    public void setStaticSoundData() {
        SoundData soundData1 = new SoundData(1, "ɪə", R.raw.sound01, "vC0h4S0YPJc");
        listSound.add(soundData1);
        SoundData soundData2 = new SoundData(2, "ʊə", R.raw.sound02, "nHSqluHrD-U");
        listSound.add(soundData2);
        SoundData soundData3 = new SoundData(3, "aɪ", R.raw.sound03, "Hb8COxAtl14");
        listSound.add(soundData3);
        SoundData soundData4 = new SoundData(4, "ɔɪ", R.raw.sound04, "lFRrEI85IcM");
        listSound.add(soundData4);
        SoundData soundData5 = new SoundData(5, "əʊ", R.raw.sound05, "r1BRCG0P9C8");
        listSound.add(soundData5);
        SoundData soundData6 = new SoundData(6, "eə", R.raw.sound06, "0J7-5maJJIk");
        listSound.add(soundData6);
        SoundData soundData7 = new SoundData(7, "aʊ", R.raw.sound07, "9WDnVMQIaTs");
        listSound.add(soundData7);
        SoundData soundData8 = new SoundData(8, "eɪ", R.raw.sound08, "5FMPlqlFt9g");
        listSound.add(soundData8);
        SoundData soundData9 = new SoundData(9, "i:", R.raw.sound09, "RZmGzSb-6OM");
        listSound.add(soundData9);
        SoundData soundData10 = new SoundData(10, "u:", R.raw.sound10, "mnKEGLuEzV4");
        listSound.add(soundData10);
        SoundData soundData11 = new SoundData(11, "ɑː", R.raw.sound11, "uDHMuMQdBNw");
        listSound.add(soundData11);
        SoundData soundData12 = new SoundData(12, "ɔː", R.raw.sound12, "KHllC40_u1Q");
        listSound.add(soundData12);
        SoundData soundData13 = new SoundData(13, "ɜ:", R.raw.sound13, "zSJJWHymEPw");
        listSound.add(soundData13);
        SoundData soundData14 = new SoundData(14, "ɪ", R.raw.sound14, "TNFKG0yvDx4");
        listSound.add(soundData14);
        SoundData soundData15 = new SoundData(15, "ʊ", R.raw.sound15, "eJ7dM_LU9t4");
        listSound.add(soundData15);
        SoundData soundData16 = new SoundData(16, "ʌ", R.raw.sound16, "PZwKFFp7V50");
        listSound.add(soundData16);
        SoundData soundData17 = new SoundData(17, "ɒ", R.raw.sound17, "MAk-XtHsyzM");
        listSound.add(soundData17);
        SoundData soundData18 = new SoundData(18, "ə", R.raw.sound18, "wg0P0oYkniE");
        listSound.add(soundData18);
        SoundData soundData19 = new SoundData(19, "e", R.raw.sound19, "hLN1cdSTDo8");
        listSound.add(soundData19);
        SoundData soundData20 = new SoundData(20, "æ", R.raw.sound20, "qVhaIHk88a8");
        listSound.add(soundData20);
        SoundData soundData21 = new SoundData(21, "b", R.raw.sound21, "hyKR7cBDpZE");
        listSound.add(soundData21);
        SoundData soundData22 = new SoundData(22, "d", R.raw.sound22, "aibpXO9uKz8");
        listSound.add(soundData22);
        SoundData soundData23 = new SoundData(23, "dʒ", R.raw.sound23, "JjVzYXCU2F8");
        listSound.add(soundData23);
        SoundData soundData24 = new SoundData(24, "g", R.raw.sound24, "HWrIXx8vwjY");
        listSound.add(soundData24);
        SoundData soundData25 = new SoundData(25, "v", R.raw.sound25, "wDLzzwYW460");
        listSound.add(soundData25);
        SoundData soundData26 = new SoundData(26, "ð", R.raw.sound26, "o49Fy1HS_rM");
        listSound.add(soundData26);
        SoundData soundData27 = new SoundData(27, "z", R.raw.sound27, "qs5K8RoFsJ4");
        listSound.add(soundData27);
        SoundData soundData28 = new SoundData(28, "ʒ", R.raw.sound28, "ubg0FlUcdO0");
        listSound.add(soundData28);
        SoundData soundData29 = new SoundData(29, "p", R.raw.sound29, "AZRREr7DqqM");
        listSound.add(soundData29);
        SoundData soundData30 = new SoundData(30, "t", R.raw.sound30, "0T1QYByMxrs");
        listSound.add(soundData30);
        SoundData soundData31 = new SoundData(31, "tʃ", R.raw.sound31, "PykxZ5kkrjs");
        listSound.add(soundData31);
        SoundData soundData32 = new SoundData(32, "k", R.raw.sound32, "d1jyIpAmLe8");
        listSound.add(soundData32);
        SoundData soundData33 = new SoundData(33, "f", R.raw.sound33, "vE12RFyH-hY");
        listSound.add(soundData33);
        SoundData soundData34 = new SoundData(34, "θ", R.raw.sound34, "b4Aj3k65HSo");
        listSound.add(soundData34);
        SoundData soundData35 = new SoundData(35, "s", R.raw.sound35, "QtH3vRXmvvo");
        listSound.add(soundData35);
        SoundData soundData36 = new SoundData(36, "ʃ", R.raw.sound36, "NF92RdZC6wE");
        listSound.add(soundData36);
        SoundData soundData37 = new SoundData(37, "m", R.raw.sound37, "QY-lIYjJGBY");
        listSound.add(soundData37);
        SoundData soundData38 = new SoundData(38, "n", R.raw.sound38, "5OXgFBSXBwE");
        listSound.add(soundData38);
        SoundData soundData39 = new SoundData(39, "ŋ", R.raw.sound39, "Ir_zghBXD_E");
        listSound.add(soundData39);
        SoundData soundData40 = new SoundData(40, "h", R.raw.sound40, "TUcjk17yRX4");
        listSound.add(soundData40);
        SoundData soundData41 = new SoundData(41, "l", R.raw.sound41, "cBxDTse71iE");
        listSound.add(soundData41);
        SoundData soundData42 = new SoundData(42, "r", R.raw.sound42, "cOHwquvtZus");
        listSound.add(soundData42);
        SoundData soundData43 = new SoundData(43, "w", R.raw.sound43, "i_ZQgrFa0ao");
        listSound.add(soundData43);
        SoundData soundData44 = new SoundData(44, "j", R.raw.sound44, "hbmqt19efi4");
        listSound.add(soundData44);
    }

    public void setStaticDataSentenceStressExample() {
        SentenceExample sentenceExample1 = new SentenceExample("DON'T SLEEP.STAY AWAKE!", R.raw.sentence_stress_example1);
        listSentenceStressExample.add(sentenceExample1);
        SentenceExample sentenceExample2 = new SentenceExample("STAND STILL.STAY THERE!", R.raw.sentence_stress_example2);
        listSentenceStressExample.add(sentenceExample2);
        SentenceExample sentenceExample3 = new SentenceExample("DRINK some of the MILK", R.raw.sentence_stress_example3);
        listSentenceStressExample.add(sentenceExample3);
        SentenceExample sentenceExample4 = new SentenceExample("GO to a SHOP", R.raw.sentence_stress_example4);
        listSentenceStressExample.add(sentenceExample4);
        SentenceExample sentenceExample5 = new SentenceExample("DID you MEET the DAUGHTER,Catherine", R.raw.sentence_stress_example5);
        listSentenceStressExample.add(sentenceExample5);
        SentenceExample sentenceExample6 = new SentenceExample("WHERE did you BUY the GUITAR?!", R.raw.sentence_stress_example6);
        listSentenceStressExample.add(sentenceExample6);
        SentenceExample sentenceExample7 = new SentenceExample("ROSES are RED.,VIOLETS are BLUE", R.raw.sentence_stress_example7);
        listSentenceStressExample.add(sentenceExample7);
        SentenceExample sentenceExample8 = new SentenceExample("the ROAD is CLOSED", R.raw.sentence_stress_example8);
        listSentenceStressExample.add(sentenceExample8);
        SentenceExample sentenceExample9 = new SentenceExample("WHERE do YOU LIVE?", R.raw.sentence_stress_example9);
        listSentenceStressExample.add(sentenceExample9);
        SentenceExample sentenceExample10 = new SentenceExample("WHERE did he TEACH?", R.raw.sentence_stress_example8);
        listSentenceStressExample.add(sentenceExample10);
    }

    public void setStaticLinkingExample() {
        SentenceExample linkingExample1 = new SentenceExample("looK At that! BreakfasT In bed", R.raw.linking_example1);
        listLinkingExample.add(linkingExample1);
        SentenceExample linkingExample2 = new SentenceExample("thiS AfternooN At fouR O'clock", R.raw.linking_example2);
        listLinkingExample.add(linkingExample2);
        SentenceExample linkingExample3 = new SentenceExample("that'S A loT Of money", R.raw.linking_example3);
        listLinkingExample.add(linkingExample3);
        SentenceExample linkingExample4 = new SentenceExample("you puT ON Your clothes", R.raw.linking_example4);
        listLinkingExample.add(linkingExample4);
        SentenceExample linkingExample5 = new SentenceExample("that'S Enough! SwitCH IT Off", R.raw.linking_example5);
        listLinkingExample.add(linkingExample5);
        SentenceExample linkingExample6 = new SentenceExample("Could I get his phoNE Number?", R.raw.linking_example6);
        listLinkingExample.add(linkingExample6);
        SentenceExample linkingExample7 = new SentenceExample("They specialize in canceR Research.", R.raw.linking_example7);
        listLinkingExample.add(linkingExample7);
        SentenceExample linkingExample8 = new SentenceExample("I feeL Like having pizza for lunch.", R.raw.linking_example8);
        listLinkingExample.add(linkingExample8);
        SentenceExample linkingExample9 = new SentenceExample("HumaN Nature is still a mystery.", R.raw.linking_example9);
        listLinkingExample.add(linkingExample9);
        SentenceExample linkingExample10 = new SentenceExample("The presentation was an enormouS Success!", R.raw.linking_example10);
        listLinkingExample.add(linkingExample10);

    }

    private void setDefaultSyllableExample() {
        WordData one_syllable = new WordData("", "", "ONE SYLLABLE WORD", "");
        listWordSyllableExample.add(one_syllable);
        WordData dog = new WordData("dɒg", "221724", "dog", "");
        listWordSyllableExample.add(dog);
        WordData green = new WordData("gri:n", "", "green", "");
        listWordSyllableExample.add(green);
        WordData quite = new WordData("kwait", "", "quite", "");
        listWordSyllableExample.add(quite);

        WordData two_syllable = new WordData("", "", "TWO SYLLABLE WORD", "");
        listWordSyllableExample.add(two_syllable);
        WordData kitchen = new WordData("'kittʃin", "", "kitchen", "");
        listWordSyllableExample.add(kitchen);
        WordData orange = new WordData("'ɒrindʒ", "", "orange", "");
        listWordSyllableExample.add(orange);
        WordData table = new WordData("'teibl", "", "table", "");
        listWordSyllableExample.add(table);

        WordData three_syllable = new WordData("", "", "THREE SYLLABLE WORD", "");
        listWordSyllableExample.add(three_syllable);
        WordData expensive = new WordData("ik'spensiv", "", "expensive", "");
        listWordSyllableExample.add(expensive);
        WordData wonderful = new WordData("'wʌndəfl", "", "wonderful", "");
        listWordSyllableExample.add(wonderful);
        WordData beautiful = new WordData("'bju:tiful", "", "beautiful", "");
        listWordSyllableExample.add(beautiful);

        WordData four_syllable = new WordData("", "", "FOUR SYLLABLE WORD", "");
        listWordSyllableExample.add(four_syllable);
        WordData comfortable = new WordData("'kʌmfətəbl", "", "comfortable", "");
        listWordSyllableExample.add(comfortable);
        WordData unrealistic = new WordData("ʌnriə'listik", "", "unrealistic", "");
        listWordSyllableExample.add(unrealistic);
        WordData increasable = new WordData("'inkri:səbl", "", "increasable", "");
        listWordSyllableExample.add(increasable);

        WordData five_syllable = new WordData("", "", "FIVE SYLLABLE WORD", "");
        listWordSyllableExample.add(five_syllable);
        WordData unbelievable = new WordData("ʌnbi'li:vəbl", "", "unbelievable", "");
        listWordSyllableExample.add(unbelievable);
        WordData disadvantageous = new WordData("disædva:n'teidʒəs", "", "disadvantageous", "");
        listWordSyllableExample.add(disadvantageous);
        WordData manufactory = new WordData("mænju'fæktəri", "", "manufactory", "");
        listWordSyllableExample.add(manufactory);

    }

    private void setDefaultWordStressExample() {
        listWordStressExample = new ArrayList<WordData>();
        WordData rule_one = new WordData("", "", "RULE ONE", "");
        listWordStressExample.add(rule_one);
        WordData progress = new WordData("ˈprəʊɡres", "", "progress", "");
        listWordStressExample.add(progress);
        WordData present = new WordData("ˈpreznt", "", "present", "");
        listWordStressExample.add(present);
        WordData engine = new WordData("ˈendʒɪn", "", "engine", "");
        listWordStressExample.add(engine);
        WordData record = new WordData("ˈrekɔːd", "", "record", "");
        listWordStressExample.add(record);
        WordData jealous = new WordData("ˈdʒeləs", "", "jealous", "");
        listWordStressExample.add(jealous);

        WordData rule_two = new WordData("", "", "RULE TWO", "");
        listWordStressExample.add(rule_two);
        WordData admit = new WordData("ədˈmɪt", "", "admit", "");
        listWordStressExample.add(admit);
        WordData announce = new WordData("əˈnaʊns", "", "announce", "");
        listWordStressExample.add(announce);
        WordData begin = new WordData("bɪˈɡɪn", "", "begin", "");
        listWordStressExample.add(begin);
        WordData decide = new WordData("dɪˈsaɪd", "", "decide", "");
        listWordStressExample.add(decide);
        WordData impress = new WordData("ɪmˈpres", "", "impress", "");
        listWordStressExample.add(impress);

        WordData rule_three = new WordData("", "", "RULE THREE", "");
        listWordStressExample.add(rule_three);
        WordData education = new WordData("ˌedʒuˈkeɪʃn", "", "education", "");
        listWordStressExample.add(education);
        WordData concentration = new WordData("ˌkɒnsnˈtreɪʃn", "", "concentration", "");
        listWordStressExample.add(concentration);
        WordData demonstration = new WordData("ˌdemənˈstreɪʃn", "", "demonstration", "");
        listWordStressExample.add(demonstration);
        WordData permission = new WordData("pəˈmɪʃn", "", "permission", "");
        listWordStressExample.add(permission);
        WordData musician = new WordData("mjuˈzɪʃn", "", "musician", "");
        listWordStressExample.add(musician);

        WordData rule_four = new WordData("", "", "RULE FOUR", "");
        listWordStressExample.add(rule_four);
        WordData economic = new WordData("ˌiːkəˈnɒmɪk", "", "economic", "");
        listWordStressExample.add(economic);
        WordData strategic = new WordData("strəˈtiːdʒɪk", "", "strategic", "");
        listWordStressExample.add(strategic);
        WordData mechanic = new WordData("məˈkænɪk", "", "mechanic", "");
        listWordStressExample.add(mechanic);
        WordData academic = new WordData("ˌækəˈdemɪk", "", "academic", "");
        listWordStressExample.add(academic);
        WordData dramatic = new WordData("drəˈmætɪk", "", "dramatic", "");
        listWordStressExample.add(dramatic);

        WordData rule_five = new WordData("", "", "RULE FIVE", "");
        listWordStressExample.add(rule_five);
        WordData employee = new WordData("ɪmˈplɔɪiː", "", "employee", "");
        listWordStressExample.add(employee);
        WordData degree = new WordData("dɪˈɡriː", "", "degree", "");
        listWordStressExample.add(degree);
        WordData shampoo = new WordData("ʃæmˈpuː", "", "shampoo", "");
        listWordStressExample.add(shampoo);
        WordData guarantee = new WordData("ˌɡærənˈtiː", "", "guarantee", "");
        listWordStressExample.add(guarantee);
        WordData refugee = new WordData("ˌrefjuˈdʒiː", "", "refugee", "");
        listWordStressExample.add(refugee);
    }
}

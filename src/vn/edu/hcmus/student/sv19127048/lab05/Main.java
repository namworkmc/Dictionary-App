package vn.edu.hcmus.student.sv19127048.lab05;

import vn.edu.hcmus.student.sv19127048.lab05.Dictionary.DictionaryController;

public class Main {

    public static void main(String[] args) {
//        DictionaryService dictionaryService = new DictionaryService();
//        System.out.println(dictionaryService.getDefinitions("a"));
//        System.out.println(dictionaryService.getDefinitions("b"));
//        System.out.println(dictionaryService.getDefinitions("c"));
//
//        dictionaryService.setDefinitions("a", "aaaaa");
//        dictionaryService.setDefinitions("a", "aaaaa");
//        System.out.println(dictionaryService.getDefinitions("a"));

        DictionaryController dictionaryController = new DictionaryController();
        System.out.println(dictionaryController.getDefinitions("Æ"));
        System.out.println(dictionaryController.getSlangWords("Food"));

        dictionaryController.addNewDefinition("LOL", "Laughing Out Loud!!!");
        System.out.println(dictionaryController.getDefinitions("LOL"));

        dictionaryController.addNewSlangWord("LOL", "bủh");
        System.out.println(dictionaryController.getDefinitions("LOL"));
    }
}

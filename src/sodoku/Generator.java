package sodoku;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Generator implements Serializable {

    private static ArrayList<Integer[][]> table = new ArrayList<>(362290);
    private static Integer[][][] sodokuTable = new Integer[9][][];

    public static void generateTable() {
        for (int w = 1; w < 10; w++) {
            for (int e = 1; e < 9; e++) {
                for (int r = 1; r < 8; r++) {
                    for (int t = 1; t < 7; t++) {
                        for (int z = 1; z < 6; z++) {
                            for (int u = 1; u < 5; u++) {
                                for (int o = 1; o < 4; o++) {
                                    for (int p = 1; p < 3; p++) {
                                        for (int a = 1; a < 2; a++) {
                                            table.add(new Integer[][]{
                                                {a, w, e
                                                },
                                                {r, t, z
                                                },
                                                {u, o, p
                                                }
                                            });
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static void writeTables() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(table);
    }

    public static void generateSodokuTabe() {
        shuffleBlocks();
        getBaseline();
        generateLastBlocks();

    }

    private static void shuffleBlocks() {
        Collections.shuffle(table);
    }

    private static void getBaseline() {
        System.out.println(table.size());
        sodokuTable[0] = table.get(1);
        sodokuTable[4] = table.get(120960);
        sodokuTable[8] = table.get(241920);
    }

    private static void generateLastBlocks() {
        for (int i = 0; i < sodokuTable.length; i++) {
            if (sodokuTable[i] == null) {
                for (Integer[][] block : table) {
                    if (validateBlock(block)/* && validateRow(block, i) && validateColumn(block, i)*/) {
                        sodokuTable[i] = block;
                    }
                }
            }
        }
    }

    private static boolean validateBlock(Integer[][] currentBlock) {
        for (Integer[][] block : sodokuTable) {
            if (Arrays.equals(block, currentBlock)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateRow(Integer[][] block, int blockID) {

        if (blockID >= 0 && blockID < 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(sodokuTable[i][j][k]!=null)
                            if (block[j][l].equals(sodokuTable[i][j][k])) {
                                return false;
                            }
                        }
                    }
                }
            }
        } else if (blockID >= 3 && blockID < 6) {
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(sodokuTable[i][j][k]!=null)
                            if (block[j][l].equals(sodokuTable[i][j][k])) {
                                return false;
                            }
                        }
                    }
                }
            }
        } else if (blockID >= 6 && blockID < 9) {
            for (int i = 6; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(sodokuTable[i][j][k]!=null)
                            if (block[j][l].equals(sodokuTable[i][j][k])) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
/*
    public static String getSodokuTable() {
        StringBuilder sb = new StringBuilder(300);
        for(int i = 0; i<9;i++){
            for(int j = 0; j<3;j++){
                for(int k = 0; k<3;k++){
                    sb.append(sodokuTable[][][]) 
                }
            }
        }
       
    }
*/
    public static Integer[][][] getSodokuTable() {
        return sodokuTable;
    }

    private static boolean validateColumn(Integer[][] block, int blockID) {
        switch (blockID) {
            case 0:
            case 3:
            case 6:
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(sodokuTable[0][j][k]!=null)
                            if (block[l][k].equals(sodokuTable[0][j][k])) {
                                return false;
                            }
                            if(sodokuTable[3][j][k]!=null)
                            if (block[l][k].equals(sodokuTable[3][j][k])) {
                                return false;
                            }
                            if(sodokuTable[6][j][k]!=null)
                            if (block[l][k].equals(sodokuTable[6][j][k])) {
                                return false;
                            }
                            
                        }
                    }
                }   break;
            case 1:
            case 4:
            case 7:
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(sodokuTable[1][j][k]!=null)
                            if (block[l][k].equals(sodokuTable[1][j][k])) {
                                return false;
                            }
                            if(sodokuTable[4][j][k]!=null)
                            if (block[l][k].equals(sodokuTable[4][j][k])) {
                                return false;
                            }
                            if(sodokuTable[7][j][k]!=null)
                            if (block[l][k].equals(sodokuTable[7][j][k])) {
                                return false;
                            }
                        }
                    }
                }   break;
            case 2:
            case 5:
            case 8:
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if(sodokuTable[2][j][k]!=null)
                            if (block[l][k].equals(sodokuTable[2][j][k])) {
                                return false;
                            }
                            if(sodokuTable[5][j][k]!=null)
                            if (block[l][k].equals(sodokuTable[5][j][k])) {
                                return false;
                            }
                            if(sodokuTable[8][j][k]!=null)
                            if (block[l][k].equals(sodokuTable[8][j][k])) {
                                return false;
                            }
                        }
                    }
                }   break;
            default:
                break;
        }
        return true;
    }
}

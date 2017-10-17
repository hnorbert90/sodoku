package sodoku;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Generator implements Serializable {

    private static ArrayList<Integer[][]> tabla = new ArrayList<>(362290);

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
                                            tabla.add(new Integer[][]{
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
        oos.writeObject(tabla);
    }
}

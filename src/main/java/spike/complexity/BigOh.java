package spike.complexity;

import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public class BigOh {

    /**
     * This is a double to make test comparisons easier.
     */
    private double count = 0;

    public void of1() {
        count++;
    }

    public void ofN(int[] a) {
        for (int n1 : a) {
            count++;
        }
    }

    public void ofNRecursive(long max) {
        if (max > 0) {
            count++;
            ofNRecursive(max - 1);
        }
    }

    public void ofLogBase2OfN(int[] a) {
        for (int i = a.length / 2; i > 0; i = i / 2) {
            count++;
        }
    }

    public void ofLogBase3OfN(int[] a) {
        for (int i = a.length / 3; i > 0; i = i / 3) {
            count++;
        }
    }

    public void ofNSquared(int[] a) {
        for (int n1 : a) {
            for (int n2 : a) {
                count++;
            }
        }
    }

    public void ofNCubed(int[] a) {
        for (int n1 : a) {
            for (int n2 : a) {
                for (int n3 : a) {
                    count++;
                }
            }
        }
    }

    public void of2ToTheN(long max) {
        if (max > 0) {
            count++;
            of2ToTheN(max - 1);
            of2ToTheN(max - 1);
        }
    }

    public void of3ToTheN(long max) {
        if (max > 0) {
            count++;
            of3ToTheN(max - 1);
            of3ToTheN(max - 1);
            of3ToTheN(max - 1);
        }
    }

    public void of4ToTheN(long max) {
        if (max > 0) {
            count++;
            of4ToTheN(max - 1);
            of4ToTheN(max - 1);
            of4ToTheN(max - 1);
            of4ToTheN(max - 1);
        }
    }

}

package de.exxcellent.challenge.finder;

abstract class AbstractLeastDifferenceFinder implements LeastDifferenceFinder {
    @Override
    public String findLeastDifference(String[][] data) {
        String result = null;
        int minDifference = Integer.MAX_VALUE;

        if (data != null) {
            for (String[] row : data) {
                if (row.length >= 3) {
                    String currentValue = row[0];
                    int value1 = Integer.parseInt(row[1]);
                    int value2 = Integer.parseInt(row[2]);

                    int difference = calculateDifference(value1, value2);

                    /*
                        If there are two rows that have the same difference between 
                        value1 and value2 and this also happens to be the least difference 
                        then we choose the first row
                    */
                    if (difference < minDifference) {
                        minDifference = difference;
                        result = currentValue;
                    }
                }
            }
        }

        return result;
    }

    protected abstract int calculateDifference(int value1, int value2);
}
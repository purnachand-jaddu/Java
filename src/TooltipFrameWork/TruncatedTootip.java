package TooltipFrameWork;


import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("rawtypes")
public class TruncatedTootip {

    private static int TRUNCATE_LIMIT_FOR_ENTRY = 80;
    private static int MAX_NUMBER_ENTRIES = 20;
    private StringBuilder sb;

    public TruncatedTootip(StringBuilder sb) {
        this.sb = sb;
    }


    public void appendCollections(List<ListInfo> listInfos) {
        int[] limits = getLimitsBasedOnMaxEntries(listInfos);
        int size = listInfos.size();
        for (int i = 0; i < size; i++) {

            ListInfo listInfo = listInfos.get(i);
            sb.append(listInfo.getHeaderName()).append("\n");
            List<?> limitedObjects = collectLimitedObjects(listInfo.getObjects(), limits[i]);
            appendToToolTip(limitedObjects, listInfo.getFunction());
            appendMoreIfNecessary(limits[i], listInfo.getObjects().size());
        }

    }

    private void appendMoreIfNecessary(int limit, int size) {

    }

    private <T> void appendToToolTip(List<T> limitedObjects, Function<T, String> function) {
        for (T limitedObject : limitedObjects) {
            sb.append(function.apply(limitedObject)).append("\n");
        }
    }

    private List<?> collectLimitedObjects(List<?> objects, int limit) {
        return objects.subList(0, limit);
    }

    private int[] getLimitsBasedOnMaxEntries(List<ListInfo> listInfos) {
        int size = listInfos.size();
        int[] limits = new int[size];
        for (int i = 0; i < size; i++) {
            limits[i] = 0;
        }
        while (sumOfLimits(limits, size) < MAX_NUMBER_ENTRIES) {
            for (int i = 0; i < size; i++) {
                if (limits[i] < listInfos.get(i).getObjects().size()) {
                    limits[i]++;
                }
            }
            if (maxLimitReached(limits, size, listInfos)) {
                break;
            }
        }
        return limits;
    }

    private boolean maxLimitReached(int[] limits, int size, List<ListInfo> listInfos) {
        for (int i = 0; i < size; i++) {
            if (limits[i] < listInfos.get(i).getObjects().size()) {
                return false;
            }
        }
        return true;
    }

    private int sumOfLimits(int[] limits, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += limits[i];
        }
        return sum;
    }
}

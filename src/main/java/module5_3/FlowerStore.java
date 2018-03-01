package module5_3;

import module5_3.flower_entities.Chamomile;
import module5_3.flower_entities.Flower;
import module5_3.flower_entities.Rose;
import module5_3.flower_entities.Tulip;

import java.util.ArrayList;
import java.util.Arrays;

public class FlowerStore {

    private int wallet;

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    /**
     * This method creates Flowers Bouquet with random Flowers position
     *
     * @param roseCount      count of roses in bouquet
     * @param chamomileCount count of chamomiles in bouquet
     * @param tulipCount     count of tulips in bouquet
     * @return Flowers Bouquet as Array of <code>Flower </code>
     */
    public Flower[] sell(int roseCount, int chamomileCount, int tulipCount) {

        int flowersCount = roseCount + chamomileCount + tulipCount;
        ArrayList<Flower> flowersBouquet = new ArrayList<>(flowersCount);

        //add roses to Flowers Bouquet
        for (int i = 0; i < roseCount; i++) {
            Rose rose = new Rose();
            flowersBouquet.add(rose);
        }

        //add chamomiles to Flowers Bouquet
        for (int i = 0; i < chamomileCount; i++) {
            Chamomile chamomile = new Chamomile();
            flowersBouquet.add(chamomile);
        }

        //add tulips to Flowers Bouquet
        for (int i = 0; i < tulipCount; i++) {
            Tulip tulip = new Tulip();
            flowersBouquet.add(tulip);
        }

        Flower[] result = flowersBouquet.toArray(new Flower[flowersBouquet.size()]);
        calculateCostOfBouquet(result);

        return result;
    }


    /**
     * This method creates Flowers Bouquet with "Rose, Chamomile, Tulip" sequence Flowers position
     *
     * @param roseCount      count of roses in bouquet
     * @param chamomileCount count of chamomiles in bouquet
     * @param tulipCount     count of tulips in bouquet
     * @return Flowers Bouquet as Array of <code>Flower </code>
     */
    public Flower[] sellSequence(int roseCount, int chamomileCount, int tulipCount) {

        int flowersCount = roseCount + chamomileCount + tulipCount;
        ArrayList<Flower> flowersBouquet = new ArrayList<>(flowersCount);


        int roseCounter = 0;
        int chamomileCounter = 0;
        int tulipCounter = 0;

        BEGIN:
        while (roseCounter < roseCount) {
            Rose rose = new Rose();
            flowersBouquet.add(rose);
            roseCounter++;

            if (chamomileCounter < chamomileCount) {
                Chamomile chamomile = new Chamomile();
                flowersBouquet.add(chamomile);
                chamomileCounter++;

                if (tulipCounter < tulipCount) {
                    Tulip tulip = new Tulip();
                    flowersBouquet.add(tulip);
                    tulipCounter++;
                    continue BEGIN;
                }
            }
        }

        Flower[] result = flowersBouquet.toArray(new Flower[flowersBouquet.size()]);
        calculateCostOfBouquet(result);

        return result;
    }


    /**
     * Calculate a sum of purchase from selling a bouquet
     *
     * @param flowers Flowers bouquet
     */
    private void calculateCostOfBouquet(Flower[] flowers) {
        Arrays.stream(flowers)
                .forEach((Flower flower) -> wallet = wallet + flower.getCost());
    }
}

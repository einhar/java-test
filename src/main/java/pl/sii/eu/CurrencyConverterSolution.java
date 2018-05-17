package pl.sii.eu;

import pl.sii.eu.model.Amount;
import pl.sii.eu.model.Currency;

public class CurrencyConverterSolution {
    public static void main(String[] args) {
        /**
         * Solution without class refactoring.
         *
         * Due to the fact, that result should be always rounded to two fractional digits,
         * but should be stored in Value(which is integer):
         * The returned Amount object contains Value which comma is shifted to the right by Amount.PRECISION,
         * so if you want to get the real value with the precision shift the comma to the left by Amount.PRECISION
         */

        CurrencyConverter currencyConverter = new CurrencyConverterImpl();

        Amount amount_EUR = new Amount(100, Currency.EUR);
        Amount amountFrom_EUR = currencyConverter.convertToPln(amount_EUR);
        System.out.println("You have converted: " + amount_EUR.getValue() + " " + Currency.EUR
                + " to " + amountFrom_EUR.getValue() / CurrencyConverterImpl.PRECISION + " " + Currency.PLN + ".");

        Amount amount_PLN = new Amount(100, Currency.PLN);
        Amount amountFrom_PLN = currencyConverter.convertToEur(amount_PLN);
        System.out.println("You have converted: " + amount_PLN.getValue() + " " + Currency.PLN
                + " to " + amountFrom_PLN.getValue() / CurrencyConverterImpl.PRECISION + " " + Currency.EUR + ".");

    }
}

/* Implementation */
class CurrencyConverterImpl implements CurrencyConverter {
    public static final double PRECISION = Math.pow(10.0, Amount.PRECISION);

    @Override
    public Amount convertToPln(Amount euroAmount) {
        return new Amount( Math.round((euroAmount.getValue() * PRECISION * CurrencyConverter.EURO_TO_PLN_RATIO)), Currency.PLN);
    }

    @Override
    public Amount convertToEur(Amount plnAmount) {
        return new Amount( Math.round((plnAmount.getValue() * PRECISION / CurrencyConverter.EURO_TO_PLN_RATIO)), Currency.EUR);
    }
}
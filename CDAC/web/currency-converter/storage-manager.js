import HttpFetcher from "./http-fetcher.js";

class StorageManager {
    static #currencyRateKey = "currencyRates";
    static #currencyRateFetchTimestamp = "currencyRatesFetchTimestamp";

    static getCurrencyRateFetchTimestamp() {
        return localStorage.getItem(this.#currencyRateFetchTimestamp);
    }

    static setCurrencyRate(rateList) {
        if(rateList == null) {
            throw new Error("Rate cannot be empty !!!");
        }
        localStorage.setItem(this.#currencyRateKey, JSON.stringify(rateList));

        let nextFetchTime = Date.now() + (2 * 1000 * 60 * 60);
        localStorage.setItem(this.#currencyRateFetchTimestamp, nextFetchTime);
    }

    static getCurrencyRate() {
        let exchangeRateJson;
        let nextFetchTime = localStorage.getItem(this.#currencyRateFetchTimestamp);

        if(nextFetchTime == null || Date.now() > nextFetchTime) {
            exchangeRateJson = new HttpFetcher().fetchCurrencyRate();
        } else {
            exchangeRateJson = JSON.parse(localStorage.getItem(this.#currencyRateKey));
        }

        return exchangeRateJson;
    }
}

export default StorageManager;
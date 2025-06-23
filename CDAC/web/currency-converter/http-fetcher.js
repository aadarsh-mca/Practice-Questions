import StorageManager from "./storage-manager.js";

class HttpFetcher {
    #baseUrl = "https://v6.exchangerate-api.com/v6/b23b874532b7fb6e21fc5c34/latest";
    #baseCurrency = "USD";

    async fetchCurrencyRate(specificCurrency) {
        let finalUrl = this.#baseUrl;
        if(specificCurrency == null) {
            finalUrl += `/${this.#baseCurrency}`;
        } else {
            finalUrl += `/${specificCurrency}`;
        }

        try {
            const response = await fetch(finalUrl);
            const jsonData = await response.json();
            
            const exchangeRateJson = jsonData["conversion_rates"];

            StorageManager.setCurrencyRate(exchangeRateJson);

            return exchangeRateJson;
        } catch(error) {
            console.log(error);
        }

        // return fetch(finalFetchUrl).then((response) => {
        //     return response.json();
        // }).then((responseBody) => {
        //     let jsonData = responseBody["conversion_rates"];

        //     let arrData = Object.entries(jsonData);
        //     arrData.filter(val => currencyList.includes(val[0]));

        //     console.log(arrData);

        //     return jsonData;
        // }).catch((error) => {
        //     console.log(error);
        // });
    }
}

export default HttpFetcher;
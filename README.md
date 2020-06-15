Application description
This application provides API which allows to get the high level overview of the state of the market.
It shows you the current best bid and ask for the default BTCUSD currency.

The application interacts with external services (providing data on the current state of the cryptocurrency market)
by using WebSocket connection that remains open and makes  it possible to obtain a fresh portion of information over time.

To start working with the application, it is enough to run the command:
curl -u username:password http://localhost:8080/trading-events

To get the data it is required to go through basic authentication.
The following permissions are used by default:
username: trader
password: trader

As a result, there is a stream of individual JSON items that arrive as information is received from a third-party service
(btw, the data is duplicated in the mongo database).


TODOs:
- transfer project to gradle
- implement flexible interaction with third-party services
- perform additional integration with coinbase & kraken services
- improve database model
- add testing of json to object mapping
- add reverse proxy
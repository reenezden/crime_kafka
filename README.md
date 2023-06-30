# Crime Event App

This repository contains two services: `CrimeEventProducer` and `CrimeEventResolver`. The `CrimeEventProducer` receives crime events from clients and saves them to a topic based on the location specified in the property file. The `CrimeEventResolver` service listens to a particular topic, fetches the message, and saves it to a resolved topic based on the configuration.

## CrimeEventProducer

The `CrimeEventProducer` service receives crime events from clients and saves them to a topic based on the property file it's running. The topic corresponds to a specific state, such as Texas. The payload of the crime event saved in the topic includes the following information:

- Image Path: Path to the image associated with the crime event
- Description: Description of the crime event
- Location: Location where the crime event occurred

### Dynamic Properties

The `CrimeEventProducer` service has the following dynamic properties:

- `server.port`: Specifies the port on which the service will run. Default is `8080`.
- `topic.location`: Specifies the topic to which crime events will be saved. Default is `texas`.

Multiple instances of the `CrimeEventProducer` service can be run on different ports, each saving crime events to different location topics.

## CrimeEventResolver

The `CrimeEventResolver` service listens to a particular topic based on the configuration it was started with. It fetches the messages from the topic and saves them to a resolved topic, which can correspond to a specific city like Texas.

### Dynamic Properties

The `CrimeEventResolver` service has the following dynamic properties:

- `server.port`: Specifies the port on which the service will run. Default is `8081`.
- `kafka.listener.location`: Specifies the topic the listener is listening to for incoming crime events.
- `kafka.resolve.location`: Specifies the topic the listener writes to when a crime event has been resolved.

Multiple instances of the `CrimeEventResolver` service can be run on different ports, with each instance listening to different locations and writing to different resolve topics.

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/crime-event-app.git

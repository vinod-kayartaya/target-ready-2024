const { Kafka } = require('kafkajs');

const kafka = new Kafka({
  brokers: ['localhost:9092'],
});

const consumer = kafka.consumer({ groupId: 'grp1' });

// run is assigned a promise
const run = async () => {
  await consumer.connect();
  await consumer.subscribe({ topic: 'location-topic', fromBeginning: false });
  await consumer.run({
    eachMessage: async ({ message }) => {
      console.log(`got this location - ${message.value.toString()}`);
    },
  });
};

// log the errors in the console
run().catch(console.log);

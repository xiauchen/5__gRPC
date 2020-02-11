global.XMLHttpRequest = require('xhr2');
const {GreeterClient} = require('./helloworld_grpc_web_pb.js');
const {HelloRequest} = require('./helloworld_pb.js');
const client = new GreeterClient('127.0.0.1:10000');

const request = new HelloRequest();
request.setName('World');

const metadata = {'custom-header-1': 'value1'};

client.helloWorld(request, metadata, (err, response) => {
//	assert.equal('aaa', response.getMessage());
});
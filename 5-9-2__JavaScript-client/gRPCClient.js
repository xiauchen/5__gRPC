const {GreeterClient} = require('./helloworld_grpc_web_pb.js');
const {HelloRequest} = require('./helloworld_pb.js');
const client = new GreeterClient('localhost:8080');

const request = new HelloRequest();
request.setMessage('World');

const metadata = {'custom-header-1': 'value1'};

client.helloWorld(request, metadata, (err, response) => {
	assert.equal('aaa', response.getMessage());
});
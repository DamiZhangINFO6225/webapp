```json
# Provider configuration
provider "aws" {
  region = "us-east-1"
}

# Create a VPC
resource "aws_vpc" "main" {
  cidr_block = "10.0.0.0/16"
}

# Create a public subnet in the VPC
resource "aws_subnet" "public" {
  vpc_id            = aws_vpc.main.id
  cidr_block        = "10.0.1.0/24"
  availability_zone = "us-east-1a"
}

# Create an internet gateway for the VPC
resource "aws_internet_gateway" "gw" {
  vpc_id = aws_vpc.main.id
}

# Attach the internet gateway to the VPC
resource "aws_vpc_attachment" "gw" {
  vpc_id       = aws_vpc.main.id
  internet_gateway_id = aws_internet_gateway.gw.id
}

# Create a security group that allows SSH, HTTP, and HTTPS traffic
resource "aws_security_group" "main" {
  name_prefix = "allow_ssh_http_https"
  vpc_id      = aws_vpc.main.id

  ingress {
    from_port = 22
    to_port   = 22
    protocol  = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port = 80
    to_port   = 80
    protocol  = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port = 443
    to_port   = 443
    protocol  = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# Create an EBS volume
resource "aws_ebs_volume" "example" {
  availability_zone = aws_subnet.public.availability_zone
  size              = 50
  type              = "gp2"
}

# Attach the EBS volume to the EC2 instance
resource "aws_volume_attachment" "example" {
  device_name = "/dev/sdf"
  volume_id   = aws_ebs_volume.example.id
  instance_id = aws_instance.example.id
}

# Create an EC2 instance in the public subnet
resource "aws_instance" "example" {
  ami           = "ami-0c94855ba95c71c99" # Ubuntu 18.04 LTS
  instance_type = "t2.micro"
  subnet_id     = aws_subnet.public.id
  vpc_security_group_ids = [aws_security_group.main.id]
}

```


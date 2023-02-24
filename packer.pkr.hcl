locals {
  source_ami = "ami-0c94855ba95c71c99"  # Replace with your desired source AMI ID
}

source "amazon-ebs" "amazon_linux2" {
  ami_name      = "Custom Application AMI"
  instance_type = "t2.micro"
  region        = "us-east-1"
  source_ami_filter {
    filters = {
      name                = "name"
      values              = ["amzn2-ami-hvm-*-x86_64-ebs"]
      most_recent         = true
      owners              = ["amazon"]
    }
  }
}

build {
  name    = "custom-application-ami"
  sources = ["source.amazon-ebs.amazon_linux2"]
  builders {
    type          = "amazon-ebs"
    ami_name      = "Custom Application AMI"
    instance_type = "t2.micro"
    region        = "us-east-1"
    source_ami    = local.source_ami
    vpc_id        = "vpc-04f8dd5d162cb3cee"
    subnet_id     = "subnet-074254daaa06ace28"
    security_group_id = "sg-0026c59922203e2aa"
  }
  provisioner "shell" {
    inline = [
      "sudo yum update -y",
      "sudo yum install -y <application-prerequisites>",
      "sudo yum install -y <middleware>",
      "sudo yum install -y <runtime>",
      "sudo yum install -y mysql",  # Replace with your desired database server
      "sudo chown -R ec2-user:ec2-user /path/to/application/artifacts",
      "sudo chmod -R 755 /path/to/application/artifacts",
    ]
  }
  provisioner "file" {
    source      = "/path/to/application/artifacts"
    destination = "/path/to/application/artifacts"
  }
  provisioner "file" {
    source      = "/path/to/application/config"
    destination = "/path/to/application/config"
  }
}

-- MarketingDb database
-- CREATE DATABASE `MarketingDb`;

DROP TABLE IF EXISTS `rules`;
DROP TABLE IF EXISTS `campaigns`;

-- campaigns table
CREATE TABLE `campaigns` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `description` VARCHAR(200) NULL DEFAULT NULL,
    `From` DATETIME NULL DEFAULT NULL,
    `name` VARCHAR(200) NULL DEFAULT NULL,
    `pictureUri` VARCHAR(200) NULL DEFAULT NULL,
    `to` DATETIME NULL DEFAULT NULL,
    `detailsUri` VARCHAR(200) NULL DEFAULT NULL,
    `pictureName` VARCHAR(200) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `rules` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `campaignId` INT(11) NULL DEFAULT NULL,
    `description` VARCHAR(200) NULL DEFAULT NULL,
    `ruletypeid` INT(11) NULL DEFAULT NULL,
    `locationId` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
    --INDEX `fk_element_campaignId` (`campaignId`),
    --CONSTRAINT `fk_element_campaignId` FOREIGN KEY (`campaignId`) REFERENCES `campaigns` (`id`)
);